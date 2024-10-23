package com.asree.stock_spring_boot.configs;

public class BaseController {
    private final String product = "/api/product";
    private final String auth = "/api/user";
    private final String content = "/api/content";

    public String getProduct() {
        return product;
    }

    public String getAuth() {
        return auth;
    }

    public String getContent() {
        return content;
    }
}
