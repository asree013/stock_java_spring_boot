package com.asree.stock_spring_boot.services;

import com.asree.stock_spring_boot.repositorys.ProductRepo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;


@Service
public class ProductService extends ProductRepo {
    private ProductRepo repo;

    public ProductService(EntityManager entityManager) {
        super(entityManager);
    }
}
