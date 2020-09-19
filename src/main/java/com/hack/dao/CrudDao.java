package com.hack.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {
    Optional<T> find(String username);
    void save(T model);
    void update(T model);
    void delete(T model);

    List<T> findAll();
}