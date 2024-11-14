package com.asree.stock_spring_boot.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "id_card", unique = true, nullable = true)
    private String idCard;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "career", nullable = true)
    private String career;

    @Column(name = "image", nullable = true)
    private String image;

    @Column(name = "create_data", updatable = false, nullable = true)
    private LocalDateTime createDate;

    @Column(name = "update_data", nullable = true)
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "user")
    private List<ProductModel> product = new ArrayList<>();

    public UserModel() {
    }


    public UserModel(String email, String password, String firstName, String lastName, String idCard, String phone, String career, String image) {
        this.email = email;
        this.image = image;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCard = idCard;
        this.phone = phone;
        this.career = career;
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

//    public List<ProductModel> getProduct() {
//        return product;
//    }
//
//    public void setProduct(List<ProductModel> product) {
//        this.product = product;
//    }

    @Override
    public String toString() {
        return "UserModel{" +
                "updateDate=" + updateDate +
                ", createDate=" + createDate +
                ", career='" + career + '\'' +
                ", phone='" + phone + '\'' +
                ", idCard='" + idCard + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
