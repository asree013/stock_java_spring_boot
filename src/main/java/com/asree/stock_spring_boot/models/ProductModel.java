package com.asree.stock_spring_boot.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "count")
    private int count;

    @Column(name = "price")
    private double price;

    @Column(name = "detail")
    private String detail;

    @Column(name = "create_data", nullable = false, updatable = false)
    private LocalDateTime createData;

    @Column(name = "update_data")
    private LocalDateTime updateData;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ProductModel() {
        this.createData = LocalDateTime.now();
        this.updateData = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductModel(String name, int count, double price, String image) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.image = image;
        this.createData = LocalDateTime.now();
        this.updateData = LocalDateTime.now();
    }

    // setter and getter ...

    public void updateProduct(String name, int count, double price, String image) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.image = image;
        this.updateData = LocalDateTime.now(); // อัปเดตวันที่
    }

    @Override
    public String toString() {
        return "EProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", image=" + image +
                ", createData=" + createData +
                ", updateData=" + updateData +
                '}';
    }
}
