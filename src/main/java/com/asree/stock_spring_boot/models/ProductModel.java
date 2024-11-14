package com.asree.stock_spring_boot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "name", unique = true)
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


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToMany(mappedBy = "products")
    private List<OrderModel> order = new ArrayList<>();

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public ProductModel() {
        this.createData = LocalDateTime.now();
        this.updateData = LocalDateTime.now();
    }



    public ProductModel(String name, int count, double price, String image, UserModel user) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.image = image;
        this.user = user; // ตั้งค่าผู้ใช้
        this.createData = LocalDateTime.now();
        this.updateData = LocalDateTime.now();
    }

    // getter and setter สำหรับ user

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDateTime getCreateData() {
        return createData;
    }

    public LocalDateTime getUpdateData() {
        return updateData;
    }

    public void updateProduct(String name, int count, double price, String image) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.image = image;
        this.updateData = LocalDateTime.now(); // อัปเดตวันที่
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", createData=" + createData +
                ", updateData=" + updateData +
                ", user=" + user +
                '}';
    }
}
