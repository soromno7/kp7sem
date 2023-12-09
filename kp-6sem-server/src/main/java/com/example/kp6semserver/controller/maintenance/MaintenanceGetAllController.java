package com.example.kp6semserver.controller.maintenance;

import com.example.kp6semserver.entity.MaintenanceEntity;
import com.example.kp6semserver.model.CarModel;
import com.example.kp6semserver.model.MaintenanceModel;
import com.example.kp6semserver.service.CarService;
import com.example.kp6semserver.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/maintenance/get-all")
public class MaintenanceGetAllController {

    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping
    public ArrayList<MaintenanceModel> getAll () {
        return maintenanceService.getAllModels();
    }

}
