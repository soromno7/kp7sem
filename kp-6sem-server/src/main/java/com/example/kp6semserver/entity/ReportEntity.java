package com.example.kp6semserver.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "Report")
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reportDate;
    private String reportTime;
    private String message;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity carItem;

    public ReportEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CarEntity getCarItem() {
        return carItem;
    }

    public void setCarItem(CarEntity carItem) {
        this.carItem = carItem;
    }
}
