package com.example.kp6semserver.controller.serviceStation;

import com.example.kp6semserver.entity.ServiceStationEntity;
import com.example.kp6semserver.service.ServiceStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/service/add")
public class ServiceCreateController {

    @Autowired
    private ServiceStationService stationService;

    @PostMapping
    public ResponseEntity create(@RequestBody ServiceStationEntity service){
        try {
            stationService.create(service);
            return ResponseEntity.ok("СТО добавлена");
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка: " + e.getMessage());
        }
    }


}
