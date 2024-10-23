package com.asree.stock_spring_boot.services;

import com.asree.stock_spring_boot.repositorys.UserRepo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class UserService extends UserRepo {
    private UserRepo repo;

    public UserService(EntityManager entityManager){
        super(entityManager);
    }
}
