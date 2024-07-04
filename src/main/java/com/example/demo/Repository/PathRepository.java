package com.example.demo.Repository;

import com.example.demo.Model.Path;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class PathRepository {
        HashMap<Long, Path> hmPath = new HashMap<Long, Path>();

    private PathRepository() {
        Path p = new Path(10.2, 1L, 2L);
        p.setId(1L);
        hmPath.put(1L, p);
    }

    public HashMap<Long, Path> findAll() {
        return hmPath;
    }

    public Path savePath(Path a) {
        hmPath.put(a.getId(), a);
        return a;
    }
}
