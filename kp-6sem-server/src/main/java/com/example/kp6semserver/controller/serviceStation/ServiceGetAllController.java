package com.example.kp6semserver.controller.serviceStation;

import com.example.kp6semserver.entity.ServiceStationEntity;
import com.example.kp6semserver.model.ServiceStationModel;
import com.example.kp6semserver.service.ServiceStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/service/get-all")
public class ServiceGetAllController {

    @Autowired
    private ServiceStationService stationService;

    @GetMapping
    public List<ServiceStationModel> getAll () {
        return stationService.getAllServices();
    }

}
