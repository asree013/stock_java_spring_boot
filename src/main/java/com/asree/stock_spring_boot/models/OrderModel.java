package com.asree.stock_spring_boot.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "detail", nullable = true)
    private String detail;

    @Column(name = "status")
    private String status;

    @Column(name = "create_data", nullable = false, updatable = false)
    private LocalDateTime createData;

    @Column(name = "update_data")
    private LocalDateTime updateData;

    @ManyToOne
    @JoinColumn(name = "product_id") // ใช้ product_id เป็น FK
    private ProductModel product; // เปลี่ยนจาก List<ProductModel> เป็น ProductModel

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private PaymentModel payment;

    // Getter และ Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public PaymentModel getPayment() {
        return payment;
    }

    public void setPayment(PaymentModel payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", detail='" + detail + '\'' +
                ", status='" + status + '\'' +
                ", createData=" + createData +
                ", updateData=" + updateData +
                ", product=" + product + // เปลี่ยนจาก productList เป็น product
                ", payment=" + payment +
                '}';
    }

    public OrderModel() {
        this.createData = LocalDateTime.now();
        this.updateData = LocalDateTime.now();
    }

    public OrderModel(String type, String detail, String status, ProductModel product, PaymentModel payment) {
        this.type = type;
        this.detail = detail;
        this.status = status;
        this.createData = LocalDateTime.now();
        this.updateData = LocalDateTime.now();
        this.product = product; // เปลี่ยนจาก productList เป็น product
        this.payment = payment;
    }
}

