package com.example.kp6semserver.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "Orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderTime;
    private String orderDate;
    private String drivePrice;
    private String driveLength;
    private String promocode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private RentalEntity rental;

    public OrderEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDrivePrice() {
        return drivePrice;
    }

    public void setDrivePrice(String drivePrice) {
        this.drivePrice = drivePrice;
    }

    public String getDriveLength() {
        return driveLength;
    }

    public void setDriveLength(String driveLength) {
        this.driveLength = driveLength;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public String getPromocode() { return promocode; }

    public void setPromocode(String promocode) { this.promocode = promocode; }
}
