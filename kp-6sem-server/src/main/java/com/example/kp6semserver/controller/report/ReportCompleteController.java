package com.example.kp6semserver.controller.report;

import com.example.kp6semserver.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/report/complete")
public class ReportCompleteController {

    @Autowired
    private ReportService reportService;

    @DeleteMapping("/{id}")
    void deleteCar(@PathVariable Long id) {
        reportService.completeReport(id);
    }

}
