package com.example.kp6semserver.controller.report;

import com.example.kp6semserver.entity.OrderEntity;
import com.example.kp6semserver.entity.ReportEntity;
import com.example.kp6semserver.service.OrderService;
import com.example.kp6semserver.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/report/create")
public class ReportCreateController {
    @Autowired
    private ReportService reportService;

    @PostMapping("/{carID}")
    public ResponseEntity createReport(@RequestBody ReportEntity report,
                                      @PathVariable Long carID)
    {
        try {
            reportService.create(report, carID);
            return ResponseEntity.ok("Жалоба отправлена");
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка: " + e.getMessage());
        }
    }

}
