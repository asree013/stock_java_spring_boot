package com.asree.stock_spring_boot.services;

import com.asree.stock_spring_boot.repositorys.PaymentRepo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends PaymentRepo {
    private PaymentRepo repo;
    public PaymentService(EntityManager entityManager) {
        super(entityManager);
    }
}
