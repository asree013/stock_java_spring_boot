package com.asree.stock_spring_boot.controllers;

import com.asree.stock_spring_boot.base.BaseControllerInterface;
import com.asree.stock_spring_boot.models.OrderModel;
import com.asree.stock_spring_boot.repositorys.OrderRepo;
import com.asree.stock_spring_boot.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController implements BaseControllerInterface<OrderModel> {
    private OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("")
    @Override
    public List<OrderModel> handlerGetAll(@RequestParam int page, @RequestParam int limit) {
        return this.service.repoFindAll(page, limit);
    }

    @Override
    public OrderModel handlerGetById(String id) {
        return this.service.repoFindById(id);
    }

    @Override
    public OrderModel handlerCreate(OrderModel data) {
        return this.service.repoCreate(data);
    }

    @Override
    public OrderModel handlerUpdate(String id, OrderModel data) {
        return this.service.repoUpdate(id, data);
    }

    @Override
    public List<OrderModel> handlerSearch(OrderModel data) {
        return List.of();
    }
}
