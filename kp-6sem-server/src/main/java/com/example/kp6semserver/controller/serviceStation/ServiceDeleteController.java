package com.example.kp6semserver.controller.serviceStation;

import com.example.kp6semserver.service.ServiceStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/service/delete")
public class ServiceDeleteController {

    @Autowired
    private ServiceStationService stationService;

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        stationService.delete(id);
    }

}
