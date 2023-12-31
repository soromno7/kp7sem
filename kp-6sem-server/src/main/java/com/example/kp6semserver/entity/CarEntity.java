package com.example.kp6semserver.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
@Table(name = "Car")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String year;
    private String engineCapacity;
    private String plateNumber;
    private String tariff;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private DealerEntity dealer;

    @OneToMany(mappedBy = "car")
    private List<OrderEntity> order;

    @OneToMany(mappedBy = "car")
    private List<MaintenanceEntity> maintenances;

    public CarEntity() {
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

    public DealerEntity getDealer() {
        return dealer;
    }

    public void setDealer(DealerEntity dealer) {
        this.dealer = dealer;
    }

    public List<MaintenanceEntity> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<MaintenanceEntity> maintenances) {
        this.maintenances = maintenances;
    }
}
