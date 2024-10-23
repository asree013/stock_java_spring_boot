package com.asree.stock_spring_boot.configs;

public class Enviroments {
    private final String product = "/product";
    private final String auth = "/user";
    private final String content = "/content";
    private final String baseDir = "upload/";

    public String getBaseDir() {
        return baseDir;
    }

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
