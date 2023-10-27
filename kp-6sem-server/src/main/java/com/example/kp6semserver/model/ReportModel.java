package com.example.kp6semserver.model;

import com.example.kp6semserver.entity.OrderEntity;
import com.example.kp6semserver.entity.ReportEntity;

import java.util.ArrayList;
import java.util.List;

public class ReportModel {
    private Long id;
    private String carName;
    private String carBrand;
    private String plateNumber;
    private String reportTime;
    private String reportDate;
    private String message;

    public static ArrayList<ReportModel> toModel(List<ReportEntity> list) {
        ArrayList<ReportModel> resList = new ArrayList<ReportModel>();

        for(ReportEntity entity : list) {
            ReportModel model = new ReportModel();
            model.setId(entity.getId());
            model.setCarBrand(entity.getCarItem().getBrand());
            model.setCarName(entity.getCarItem().getName());
            model.setReportDate(entity.getReportDate());
            model.setReportTime(entity.getReportTime());
            model.setPlateNumber(entity.getCarItem().getPlateNumber());
            model.setMessage(entity.getMessage());

            resList.add(model);
        }

        return resList;
    }

    public ReportModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
