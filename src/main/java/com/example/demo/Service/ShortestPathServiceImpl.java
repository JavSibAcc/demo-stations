package com.example.demo.Service;

import com.example.demo.Model.Path;
import com.example.demo.Model.resultDijkstra;
import com.example.demo.Repository.PathRepository;
import com.example.demo.Repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static java.util.Arrays.*;

@Service
public class ShortestPathServiceImpl implements ShortestPathService {

    @Autowired
    PathRepository pathRepository;

    @Autowired
    StationRepository stationRepository;

    double[][] graph;

    @Override
    public resultDijkstra getShortestPath(Long source_id, Long destination_id) {

        int orig = Math.toIntExact(source_id);
        int desti = Math.toIntExact(destination_id);
        int V = stationRepository.hmStation.size();
        if (orig > V-1 || desti > V-1)
            return null;

        HashMap<Long, Path> hmPath = pathRepository.hmPath;
        graph = createMatrix(hmPath, V);

        return dijkstra(graph, orig, desti);
    }


    private double[][] createMatrix(HashMap<Long, Path> hmPath, int V)
    {
        double[][] graph = new double[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = Double.MAX_VALUE;
                if(i == j)
                    graph[i][j] = 0;
            }
        }

        for (Long clave:hmPath.keySet()) {
            Path valor = hmPath.get(clave);
            //System.out.println("Clave: " + clave + ", valor: " + valor);

            int i = valor.getSource_id();
            int j = valor.getDestination_id();
            graph[i][j] = valor.getCost();
            graph[j][i] = valor.getCost();  // bidireccional
        }
        return graph;
    }

    private static int minDistance(double[] dist, boolean[] verticeYaProcesado, int V)
    {
        double min = Double.MAX_VALUE;
        int min_index = 0;

        for (int v = 0; v < V; v++)
            if (!verticeYaProcesado[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    private static resultDijkstra dijkstra(double[][] grafo, int orig, int dest)
    {
        int V = grafo.length;
        double[] dist = new double[V];
        String[] ruta = new String[V];
        boolean[] verticeYaProcesado = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Double.MAX_VALUE;
            ruta[i] = "";
            verticeYaProcesado[i] = false;
        }
        dist[orig] = 0;

        for (int count = 0; count < V-1; count++)
        {
            int u = minDistance(dist, verticeYaProcesado, V);

            verticeYaProcesado[u] = true;

            for (int v = 0; v < V; v++)
                if (!verticeYaProcesado[v] && grafo[u][v] > 0
                        && dist[u] != Double.MAX_VALUE
                        && dist[u]+grafo[u][v] < dist[v])
                {
                    dist[v] = dist[u] + grafo[u][v];
                    ruta[v] += u + ", ";
                }
        }
        for (int v = 0; v < V; v++) ruta[v] += v;

        long[] arrDest = stream(ruta[dest].split(","))
                .map(String::trim)
                .mapToLong(Long::valueOf)
                .toArray();

        return (new resultDijkstra(arrDest, dist[dest]));
    }
}
