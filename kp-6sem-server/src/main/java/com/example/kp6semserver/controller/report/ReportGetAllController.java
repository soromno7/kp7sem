package com.example.kp6semserver.controller.report;

import com.example.kp6semserver.entity.CarEntity;
import com.example.kp6semserver.model.ReportModel;
import com.example.kp6semserver.service.CarService;
import com.example.kp6semserver.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/report/get-all")
public class ReportGetAllController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<ReportModel> getAllReports () {
        return reportService.getAllReports();
    }

}
