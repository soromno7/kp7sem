package com.example.kp6semserver.model;

import com.example.kp6semserver.entity.CarEntity;
import com.example.kp6semserver.entity.ContractEntity;

import java.util.ArrayList;
import java.util.List;

public class ContractModel {

    private Long id;

    private String price;
    private String quantity;
    private String dealer;


    public static ContractModel toModelOne(ContractEntity entity) {
        ContractModel model = new ContractModel();
        model.setId(entity.getId());
        model.setPrice(entity.getPrice());
        model.setQuantity(entity.getQuantity());
        model.setDealer(entity.getDealer().getName());

        return model;
    }

    public static ArrayList<ContractModel> toModel(List<ContractEntity> list) {
        ArrayList<ContractModel> resList = new ArrayList<ContractModel>();

        for(ContractEntity entity : list) {
            ContractModel model = new ContractModel();

            model.setId(entity.getId());
            model.setPrice(entity.getPrice());
            model.setQuantity(entity.getQuantity());
            model.setDealer(entity.getDealer().getName());

            resList.add(model);
        }

        return resList;
    }

    public ContractModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }
}
