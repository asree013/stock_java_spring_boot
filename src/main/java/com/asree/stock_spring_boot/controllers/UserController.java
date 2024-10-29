package com.asree.stock_spring_boot.controllers;

import com.asree.stock_spring_boot.base.BaseControllerInterface;
import com.asree.stock_spring_boot.models.UserModel;
import com.asree.stock_spring_boot.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
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
        return this.service.repoFindById(id);
    }

    @PostMapping("")
    @Override
    public UserModel handlerCreate(@RequestBody UserModel data) {
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

    @PostMapping("sing_in")
    public String handlerSingIn(@RequestBody UserModel data){
        return this.service.signIn(data);
    }

    @PostMapping("sing_up")
    public UserModel handlerSingUp(@RequestBody UserModel data) {
        return this.service.singUp(data);
    }
}
