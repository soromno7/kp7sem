package com.example.kp6semserver.model;

import com.example.kp6semserver.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderModel {
    private Long id;
    private String clientName;
    private String clientLastName;
    private String carBrand;
    private String carName;
    private String plateNumber;
    private String tariff;
    private String orderTime;
    private String orderDate;
    private String drivePrice;
    private String driveLength;

    // List<OrderModel>

    public static OrderModel toModelOne(OrderEntity entity) {
        OrderModel model = new OrderModel();
        model.setId(entity.getId());
        model.setCarBrand(entity.getCar().getBrand());
        model.setCarName(entity.getCar().getName());
        model.setOrderDate(entity.getOrderDate());
        model.setOrderTime(entity.getOrderTime());
        model.setClientName(entity.getUser().getFirst_name());
        model.setClientLastName(entity.getUser().getLast_name());
        model.setDriveLength(entity.getDriveLength());
        model.setDrivePrice(entity.getDrivePrice());
        model.setPlateNumber(entity.getCar().getPlateNumber());
        model.setTariff(entity.getCar().getTariff());

        return model;
    }
    public static ArrayList<OrderModel> toModel(List<OrderEntity> list) {
        ArrayList<OrderModel> resList = new ArrayList<OrderModel>();

        for(OrderEntity entity : list) {
            OrderModel model = new OrderModel();
            model.setId(entity.getId());
            model.setCarBrand(entity.getCar().getBrand());
            model.setCarName(entity.getCar().getName());
            model.setOrderDate(entity.getOrderDate());
            model.setOrderTime(entity.getOrderTime());
            model.setClientName(entity.getUser().getFirst_name());
            model.setClientLastName(entity.getUser().getLast_name());
            model.setDriveLength(entity.getDriveLength());
            model.setDrivePrice(entity.getDrivePrice());
            model.setPlateNumber(entity.getCar().getPlateNumber());
            model.setTariff(entity.getCar().getTariff());

            resList.add(model);
        }

        return resList;
    }

    public OrderModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
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
}
