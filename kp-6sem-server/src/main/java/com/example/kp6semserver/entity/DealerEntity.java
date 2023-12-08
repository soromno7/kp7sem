package com.example.kp6semserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Dealer")
public class DealerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String slogan;
    @Column(name = "descr", length = 800)
    private String descr;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dealer")
    private List<OrderEntity> orders;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dealer")
    private List<CarEntity> cars;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dealer")
    private List<ServiceStationEntity> stations;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
