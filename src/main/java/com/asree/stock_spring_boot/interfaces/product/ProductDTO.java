package com.asree.stock_spring_boot.interfaces.product;

import java.time.LocalDateTime;

public class ProductDTO {
    String id;
    String name;
    String image;
    int count;
    double price;
    String detail;
    LocalDateTime createData;
    LocalDateTime updateData;
    UserDTO user;

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

    public void setCreateData(LocalDateTime createData) {
        this.createData = createData;
    }

    public LocalDateTime getUpdateData() {
        return updateData;
    }

    public void setUpdateData(LocalDateTime updateData) {
        this.updateData = updateData;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
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

    public ProductDTO() {
        this.createData = createData;
        this.updateData = updateData;
    }
}

class UserDTO {
    String id;
    String firstName;
    String lastName;
    String image;
}
