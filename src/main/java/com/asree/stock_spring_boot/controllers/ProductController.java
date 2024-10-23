package com.asree.stock_spring_boot.controllers;

import com.asree.stock_spring_boot.interfaces.BaseControllerInterface;
import com.asree.stock_spring_boot.models.ProductModel;
import com.asree.stock_spring_boot.models.UserModel;
import com.asree.stock_spring_boot.services.ProductService;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController implements BaseControllerInterface<ProductModel> {
    private ProductService service;

    @Autowired
    public ProductController(ProductService productService) {
        this.service = productService;
    }

    @GetMapping("")
    @Override
    public List<ProductModel> handlerGetAll(@RequestParam int page, @RequestParam int limit) {
        return this.service.repoFindAll(page, limit);
    }

    @GetMapping("{id}")
    @Override
    public ProductModel handlerGetById(@PathVariable String id) {
        return this.service.repoFindById(id);
    }

    @PostMapping("")
    @Override
    public ProductModel handlerCreate(@RequestBody ProductModel data) {
        return this.service.repoCreate(data);
    }

    @PutMapping("{id}")
    @Override
    public ProductModel handlerUpdate(@PathVariable String id, @RequestBody ProductModel data) {
        return this.service.repoUpdate(id, data);
    }

    @GetMapping("search")
    @Override
    public List<ProductModel> handlerSearch(@RequestBody ProductModel data) {
        return this.service.repoSearch(data);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

}
