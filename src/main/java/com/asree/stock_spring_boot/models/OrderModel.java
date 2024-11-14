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

    @Column(name = "type", nullable = true)
    private String type;

    @Column(name = "detail", nullable = true)
    private String detail;

    @Column(name = "status", nullable = true)
    private String status;

    @Column(name = "total_price", nullable = true)
    private double totalPrice;

    @Column(name = "create_data", nullable = false, updatable = false)
    private LocalDateTime createData;

    @Column(name = "update_data")
    private LocalDateTime updateData;

    @ManyToMany
    @JoinTable(
            name = "product_list",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductModel> products;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_id", nullable = false)
    private PaymentModel payments;

    // Constructor


    public OrderModel() {
        this.createData = LocalDateTime.now();
        this.updateData = LocalDateTime.now();
    }

    public OrderModel(String id,String type, String detail, String status, double totalPrice, LocalDateTime createData, LocalDateTime updateData, List<ProductModel> products, PaymentModel payment) {
        this.id = id;
        this.type = type;
        this.detail = detail;
        this.status = status;
        this.totalPrice = totalPrice;
        this.createData = createData;
        this.updateData = updateData;
        this.products = products;
//        this.payment = payment;
    }

    // Getter และ Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    public PaymentModel getPayment() {
        return payments;
    }

    public void setPayment(PaymentModel payment) {
        this.payments = payment;
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
                ", products=" + products +
                ", totalPrice=" + totalPrice +
                ", payment=" + payments +
                '}';
    }
}
