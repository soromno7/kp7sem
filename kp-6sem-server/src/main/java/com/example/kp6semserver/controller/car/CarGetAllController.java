package com.example.kp6semserver.controller.car;

import com.example.kp6semserver.entity.CarEntity;
import com.example.kp6semserver.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/car/get-all")
public class CarGetAllController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarEntity> getAllCars () {
        return carService.getAllCars();
    }

}
