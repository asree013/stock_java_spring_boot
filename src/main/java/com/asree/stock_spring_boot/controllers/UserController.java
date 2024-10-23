package com.asree.stock_spring_boot.controllers;

import com.asree.stock_spring_boot.interfaces.BaseControllerInterface;
import com.asree.stock_spring_boot.models.UserModel;
import com.asree.stock_spring_boot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController implements BaseControllerInterface<UserModel> {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("")
    @Override
    public List<UserModel> handlerGetAll(@RequestParam int page, @RequestParam int limit) {
        return this.service.repoFindAll(page, limit);
    }

    @Override
    public UserModel handlerGetById(String id) {
        return null;
    }

    @PostMapping("")
    @Override
    public UserModel handlerCreate(@RequestBody UserModel data) {
        System.out.println(data);
        return service.repoCreate(data);
    }

    @Override
    public UserModel handlerUpdate(String id, UserModel data) {
        return null;
    }

    @Override
    public List<UserModel> handlerSearch(UserModel data) {
        return List.of();
    }
}
