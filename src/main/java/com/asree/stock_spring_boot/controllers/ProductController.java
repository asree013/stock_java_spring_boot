package com.asree.stock_spring_boot.controllers;

import com.asree.stock_spring_boot.base.BaseControllerInterface;
import com.asree.stock_spring_boot.interfaces.product.ProductDTO;
import com.asree.stock_spring_boot.models.ProductModel;
import com.asree.stock_spring_boot.services.ProductService;
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

    @GetMapping()
    public List<ProductModel> handlerGetAll(@RequestParam int page, @RequestParam int limit) {
        return this.service.repoFindAll(page, limit);
    }

    @GetMapping("{id}")
    public ProductModel handlerGetById(@PathVariable String id) {
        return this.service.repoFindById(id);
    }

    @PostMapping()
    public ProductModel handlerCreate(@RequestBody ProductModel data) {
        System.out.println(" ---------- create product");
        System.out.println(data);
        return this.service.repoCreate(data);
    }

    @PutMapping("{id}")
    public ProductModel handlerUpdate(@PathVariable String id, @RequestBody ProductModel data) {
        return this.service.repoUpdate(id, data);
    }

    @GetMapping("search")
    public List<ProductModel> handlerSearch(@RequestBody ProductModel data) {
        return this.service.repoSearch(data);
    }



}
