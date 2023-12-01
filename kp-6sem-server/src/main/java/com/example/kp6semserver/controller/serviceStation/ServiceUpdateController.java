package com.example.kp6semserver.controller.serviceStation;

import com.example.kp6semserver.entity.ServiceStationEntity;
import com.example.kp6semserver.exception.common.ObjDoesNotExist;
import com.example.kp6semserver.service.ServiceStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/service/update")
public class ServiceUpdateController {

    @Autowired
    private ServiceStationService stationService;

    @PutMapping("/{id}")
    ServiceStationEntity update(@RequestBody ServiceStationEntity service, @PathVariable Long id) throws ObjDoesNotExist {
        return stationService.update(service);
    }

}
