package com.example.kp6semserver.model;

import com.example.kp6semserver.entity.CarEntity;
import com.example.kp6semserver.entity.MaintenanceEntity;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceModel {

    private Long id;
    private String address;
    private String date;
    private Long userID;
    private String firstName;
    private String lastName;
    private String carName;
    private Long carID;


    public static MaintenanceModel toModelOne(MaintenanceEntity entity) {
        MaintenanceModel model = new MaintenanceModel();

        model.setId(entity.getId());
        model.setAddress(entity.getService());
        model.setDate(entity.getDate());
        model.setCarID(entity.getCar().getId());
        model.setFirstName(entity.getUser().getFirst_name());
        model.setLastName(entity.getUser().getLast_name());
        model.setCarName(entity.getCar().getName());
        model.setUserID(entity.getUser().getId());

        return model;
    }

    public static ArrayList<MaintenanceModel> toModel(List<MaintenanceEntity> list) {
        ArrayList<MaintenanceModel> resList = new ArrayList<MaintenanceModel>();

        for(MaintenanceEntity entity : list) {
            MaintenanceModel model = new MaintenanceModel();

            model.setId(entity.getId());
            model.setAddress(entity.getService());
            model.setDate(entity.getDate());
            model.setCarID(entity.getCar().getId());
            model.setFirstName(entity.getUser().getFirst_name());
            model.setLastName(entity.getUser().getLast_name());
            model.setCarName(entity.getCar().getName());
            model.setUserID(entity.getUser().getId());

            resList.add(model);
        }

        return resList;
    }

    public MaintenanceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getCarID() {
        return carID;
    }

    public void setCarID(Long carID) {
        this.carID = carID;
    }
}
