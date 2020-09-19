package com.hack.dao;

public interface CrudDao<T> {
    T find(String id);
    void save(T model);
    void update(T model);
    void delete(T model);
}