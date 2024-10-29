package com.asree.stock_spring_boot.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class PaymentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "status_payment")
    private String statusPayment;

    @Column(name = "type_payment")
    private String typePayment;

    @Column(name = "create_data", nullable = false, updatable = false)
    private LocalDateTime createData;

    @Column(name = "update_data")
    private LocalDateTime updateData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private OrderModel order;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
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

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "PaymentModel{" +
                "updateData=" + updateData +
                ", createData=" + createData +
                ", typePayment='" + typePayment + '\'' +
                ", statusPayment='" + statusPayment + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public PaymentModel() {
        this.createData = LocalDateTime.now();
        this.updateData = LocalDateTime.now();
    }

    public PaymentModel(String statusPayment, String typePayment, LocalDateTime createData, LocalDateTime updateData, OrderModel order) {
        this.statusPayment = statusPayment;
        this.typePayment = typePayment;
        this.createData = LocalDateTime.now();
        this.updateData = LocalDateTime.now();
        this.order = order;
    }
}
