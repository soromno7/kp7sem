package com.example.kp6semserver.service;

import com.example.kp6semserver.model.OrderModel;
import com.example.kp6semserver.entity.CarEntity;
import com.example.kp6semserver.entity.OrderEntity;
import com.example.kp6semserver.entity.ReportEntity;
import com.example.kp6semserver.exception.common.ObjDoesNotExist;
import com.example.kp6semserver.model.ReportModel;
import com.example.kp6semserver.repository.CarRepo;
import com.example.kp6semserver.repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ReportService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ReportRepo reportRepo;

    public ReportEntity create(ReportEntity report, Long carID) {
        CarEntity car = carRepo.findById(carID).get();

        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("kk:mm");
        String strDate = formatDate.format(date);
        String strTime = formatTime.format(date);

        report.setReportDate(strDate);
        report.setReportTime(strTime);
        report.setCarItem(car);
        report.setMessage(report.getMessage());

        return reportRepo.save(report);
    }

    public ArrayList<ReportModel> getAllReports() { return ReportModel.toModel(reportRepo.findAll());}

    public void completeReport(Long id) { reportRepo.deleteById(id);}


}
