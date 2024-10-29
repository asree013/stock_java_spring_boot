package com.asree.stock_spring_boot.services;

import com.asree.stock_spring_boot.repositorys.OrderRepo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends OrderRepo {
    private OrderRepo repo;

    public OrderService(EntityManager entityManager) {
        super(entityManager);
    }
}
