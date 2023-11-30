package com.example.kp6semserver.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
@Table(name = "ServiceStation")
public class ServiceStationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;


    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private DealerEntity service_station;

    public ServiceStationEntity() {
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

    public String getAddress() {
        return name;
    }

    public void setAddress(String name) {
        this.name = name;
    }



}
