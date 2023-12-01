package com.example.kp6semserver.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Dealer")
public class DealerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "dealer_order")
    private List<OrderEntity> orders;

    @OneToOne(mappedBy = "dealer")
    private ContractEntity contract;

    @OneToMany(mappedBy = "dealer")
    private List<CarEntity> cars;

    @OneToMany(mappedBy = "service_station")
    private List<ServiceStationEntity> service_station;

    public DealerEntity() {
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
}
