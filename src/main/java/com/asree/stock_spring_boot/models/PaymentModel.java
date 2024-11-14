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

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false) // ต้องแน่ใจว่าเป็น not-null
    private OrderModel order;

    // Constructor
    public PaymentModel(String statusPayment, String typePayment, OrderModel order) {
        this.statusPayment = statusPayment;
        this.typePayment = typePayment;
        this.createData = LocalDateTime.now();
        this.updateData = LocalDateTime.now();
        this.order = order; // ตั้งค่าการอ้างอิง order
    }

    // Getter และ Setter
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
        this.updateData = LocalDateTime.now(); // อัปเดตเวลาเมื่อมีการเปลี่ยนแปลง
    }

    public String getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
        this.updateData = LocalDateTime.now(); // อัปเดตเวลาเมื่อมีการเปลี่ยนแปลง
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
                "id='" + id + '\'' +
                ", statusPayment='" + statusPayment + '\'' +
                ", typePayment='" + typePayment + '\'' +
                ", createData=" + createData +
                ", updateData=" + updateData +
                ", order=" + order.getId() +  // หรือแสดงข้อมูลที่สำคัญของ OrderModel
                '}';
    }
}

