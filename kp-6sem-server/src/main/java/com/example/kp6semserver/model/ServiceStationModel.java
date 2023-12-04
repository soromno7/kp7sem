package com.example.kp6semserver.model;

import com.example.kp6semserver.entity.ServiceStationEntity;

import java.util.ArrayList;
import java.util.List;

public class ServiceStationModel {

    private Long id;
    private String city;
    private String street;
    private String street_number;
    private String dealer;


    public static ServiceStationModel toModelOne(ServiceStationEntity entity) {
        ServiceStationModel model = new ServiceStationModel();
        model.setId(entity.getId());
        model.setDealer(entity.getDealer().getName());
        model.setCity(entity.getCity());
        model.setStreet(entity.getStreet());
        model.setStreet_number(entity.getStreet_number());

        return model;
    }

    public static ArrayList<ServiceStationModel> toModel(List<ServiceStationEntity> list) {
        ArrayList<ServiceStationModel> resList = new ArrayList<ServiceStationModel>();

        for(ServiceStationEntity entity : list) {
            ServiceStationModel model = new ServiceStationModel();

            model.setId(entity.getId());
            model.setDealer(entity.getDealer().getName());
            model.setCity(entity.getCity());
            model.setStreet(entity.getStreet());
            model.setStreet_number(entity.getStreet_number());

            resList.add(model);
        }

        return resList;
    }

    public ServiceStationModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }
}
