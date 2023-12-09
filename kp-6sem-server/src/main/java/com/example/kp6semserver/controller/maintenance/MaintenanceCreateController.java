package com.example.kp6semserver.controller.maintenance;

import com.example.kp6semserver.entity.MaintenanceEntity;
import com.example.kp6semserver.entity.OrderEntity;
import com.example.kp6semserver.service.MaintenanceService;
import com.example.kp6semserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/maintenance/create")
public class MaintenanceCreateController {
    @Autowired
    private MaintenanceService maintenanceService;

    @PostMapping("/{userID}/{carID}")
    public ResponseEntity create(@RequestBody MaintenanceEntity maintenance,
                                      @PathVariable Long userID, @PathVariable Long carID)
    {
        try {
            maintenanceService.create(maintenance, userID, carID);
            return ResponseEntity.ok("ok");
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка: " + e.getMessage());
        }
    }

}
