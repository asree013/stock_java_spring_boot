package com.asree.stock_spring_boot.configs;

public class Enviroments {
    private final String product = "/product";
    private final String auth = "/user";
    private final String content = "/content";
    private final String baseDir = "upload/";
    private final String SECRET_KEY = "Jj8!G7n$f&2p9QrE4sT@YxU3z4#H1k8L";

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

    public String getSECRET_KEY() {
        return SECRET_KEY;
    }
}
