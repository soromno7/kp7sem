package com.example.kp6semserver.controller.serviceStation;

import com.example.kp6semserver.entity.ServiceStationEntity;
import com.example.kp6semserver.model.CarModel;
import com.example.kp6semserver.model.OrderModel;
import com.example.kp6semserver.service.CarService;
import com.example.kp6semserver.service.OrderService;
import com.example.kp6semserver.service.ServiceStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/service/get-by-dealer")
public class ServiceGetByDealerController {

    @Autowired
    private ServiceStationService serviceStationService;

    @GetMapping("/{id}")
    public ArrayList<ServiceStationEntity> getServicesByDealer (@PathVariable Long id) {
        return serviceStationService.getServicesByDealer(id);
    }

}
