package com.asree.stock_spring_boot.base;

import java.util.List;

public interface BaseControllerInterface<T> {
    List<T> handlerGetAll(int page, int limit);
    T handlerGetById(String id);
    T handlerCreate(T data);
    T handlerUpdate(String id, T data);
    List<T> handlerSearch(T data);
}
