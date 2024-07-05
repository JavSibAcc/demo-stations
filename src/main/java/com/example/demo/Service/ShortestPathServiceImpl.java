package com.example.demo.Service;

import com.example.demo.Model.Path;
import com.example.demo.Repository.PathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ShortestPathServiceImpl implements ShortestPathService {

    @Autowired
    PathRepository pathRepository;

    HashMap<Long, Path> hmPath;
    int V = 0;
    double[][] graph;

    @Override
    public HashMap<Long, String> getShortestPath(Long source_id, Long destination_id) {

        createMatrix();

        return null;
    }

    @Override
    public Long createShortestPath() {
        return null;
    }

    private void createMatrix()
    {
        this.hmPath = pathRepository.hmPath;
        this.V = hmPath.size();
        this.graph = new double[V][V];

        double[][] grapho = {
                {0, 10, 2, 80},
                {10, 0, 4, 50},
                {2, 4, 0, 100},
                {80, 50, 100, 0}
        };

        dijkstra(grapho, 0, grapho.length);
    }

    private static void printSolution(double[] dist, String[] ruta, int V, int src)
    {
        System.out.println("-----------------------------------------------------");
        System.out.println("Distancia al vertice desde el origen");
        System.out.println("Origen \t\t Destino \t Distancia \t Ruta");
        for (int i = 0; i < V; i++) {
            System.out.println(src + " \t\t\t " + i + " \t\t\t " + dist[i] + " \t\t " + ruta[i]);
        }
        System.out.println("-----------------------------------------------------");
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

    private static void dijkstra(double[][] grafo, int src, int V)
    {
        double[] dist = new double[V];
        String[] ruta = new String[V];
        boolean[] verticeYaProcesado = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Double.MAX_VALUE;
            ruta[i] = "";
            verticeYaProcesado[i] = false;
        }
        dist[src] = 0;

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

        printSolution(dist, ruta, V, src);
    }
}
