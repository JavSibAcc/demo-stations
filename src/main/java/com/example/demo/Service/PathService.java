package com.example.demo.Service;

import com.example.demo.Model.Path;

import java.util.HashMap;
import java.util.Optional;

public interface PathService {
    HashMap<Long, Path> getAllPaths();
    Optional<Path> getPathById(Long id);
    Boolean deletePathById (Long id);

    Path savePath(Path a);

    Long createPath(Path a);
}
