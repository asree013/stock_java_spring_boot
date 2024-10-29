package com.asree.stock_spring_boot.base;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseRepoInterface<T> {
    T repoCreate(T data);
    T repoUpdate(String id, T data);
    T repoFindById(String id);
    List<T> repoFindAll(int page, int limit);
    List<T> repoSearch(T data);
}