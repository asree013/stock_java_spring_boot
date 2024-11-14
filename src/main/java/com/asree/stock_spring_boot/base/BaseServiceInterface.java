package com.asree.stock_spring_boot.base;

import java.util.List;

public interface BaseServiceInterface<T> {
    List<T> findAll(int page, int limit);
    T findById(String id);
    T updateById(String id, T data);
    T deleteById(String id);
    List<T> search(T data);
    T create(T data);
}
