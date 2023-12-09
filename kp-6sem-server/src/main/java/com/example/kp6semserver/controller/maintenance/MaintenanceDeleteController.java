package com.example.kp6semserver.controller.maintenance;

import com.example.kp6semserver.service.CarService;
import com.example.kp6semserver.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/maintenance/delete")
public class MaintenanceDeleteController {

    @Autowired
    private MaintenanceService maintenanceService;

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        maintenanceService.delete(id);
    }

}
