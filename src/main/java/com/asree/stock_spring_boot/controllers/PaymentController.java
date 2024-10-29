package com.asree.stock_spring_boot.controllers;

import com.asree.stock_spring_boot.base.BaseControllerInterface;
import com.asree.stock_spring_boot.models.PaymentModel;
import com.asree.stock_spring_boot.services.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment")
public class PaymentController implements BaseControllerInterface<PaymentModel> {
    private PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping
    @Override
    public List<PaymentModel> handlerGetAll(@RequestParam int page, @RequestParam int limit) {
        return service.repoFindAll(page, limit);
    }

    @Override
    public PaymentModel handlerGetById(String id) {
        return null;
    }

    @Override
    public PaymentModel handlerCreate(PaymentModel data) {
        return null;
    }

    @Override
    public PaymentModel handlerUpdate(String id, PaymentModel data) {
        return null;
    }

    @Override
    public List<PaymentModel> handlerSearch(PaymentModel data) {
        return List.of();
    }
}
