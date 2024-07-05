package com.example.demo.Repository;

import com.example.demo.Model.Path;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class PathRepository {

    public HashMap<Long, Path> hmPath = new HashMap<Long, Path>();

    private PathRepository() {
        hmPath.put(1L, new Path(1L, 50.0, 0L, 1L));
        hmPath.put(2L, new Path(2L, 100.0, 0L, 2L));
        hmPath.put(3L, new Path(3L, 60.0, 0L, 3L));
        hmPath.put(4L, new Path(4L, 20.0, 3L, 2L));
    }

    public HashMap<Long, Path> findAll() {
        return hmPath;
    }

    public Path savePath(Path a) {
        hmPath.put(a.getId(), a);
        return a;
    }
}
