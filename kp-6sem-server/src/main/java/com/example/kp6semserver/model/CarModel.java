package com.example.kp6semserver.model;

import com.example.kp6semserver.entity.CarEntity;

import java.util.ArrayList;
import java.util.List;

public class CarModel {

    private Long id;
    private String name;
    private String year;
    private String isMaintained;
    private String seatsQuantity;
    private String engineCapacity;
    private String plateNumber;
    private String tariff;
    private String dealer;


    public static CarModel toModelOne(CarEntity entity) {
        CarModel model = new CarModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setYear(entity.getYear());
        model.setIsMaintained(entity.getIsMaintained());
        model.setSeatsQuantity(entity.getSeatsQuantity());
        model.setEngineCapacity(entity.getEngineCapacity());
        model.setPlateNumber(entity.getPlateNumber());
        model.setTariff(entity.getTariff());
        model.setDealer(entity.getDealer().getName());

        return model;
    }

    public static ArrayList<CarModel> toModel(List<CarEntity> list) {
        ArrayList<CarModel> resList = new ArrayList<CarModel>();

        for(CarEntity entity : list) {
            CarModel model = new CarModel();

            model.setId(entity.getId());
            model.setName(entity.getName());
            model.setYear(entity.getYear());
            model.setIsMaintained(entity.getIsMaintained());
            model.setSeatsQuantity(entity.getSeatsQuantity());
            model.setEngineCapacity(entity.getEngineCapacity());
            model.setPlateNumber(entity.getPlateNumber());
            model.setTariff(entity.getTariff());
            model.setDealer(entity.getDealer().getName());

            resList.add(model);
        }

        return resList;
    }

    public CarModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIsMaintained() {
        return isMaintained;
    }

    public void setIsMaintained(String isMaintained) {
        this.isMaintained = isMaintained;
    }

    public String getSeatsQuantity() {
        return seatsQuantity;
    }

    public void setSeatsQuantity(String seatsQuantity) {
        this.seatsQuantity = seatsQuantity;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
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

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }
}
