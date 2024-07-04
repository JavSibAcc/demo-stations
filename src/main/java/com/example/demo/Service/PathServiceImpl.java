package com.example.demo.Service;

import com.example.demo.Model.Path;
import com.example.demo.Repository.PathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class PathServiceImpl implements PathService {

    @Autowired
    PathRepository pathRepository;

    @Override
    public HashMap<Long, Path> getAllPaths() {
        return pathRepository.findAll();
    }

    @Override
    public Optional<Path> getPathById(Long id) {
        return Optional.empty();
    }

    @Override
    public Boolean deletePathById(Long id) {
        return null;
    }

    @Override
    public Path savePath(Path a) {
        return pathRepository.savePath(a);
    }

    @Override
    public Long createPath(Path a) {
        return null;
    }
}
