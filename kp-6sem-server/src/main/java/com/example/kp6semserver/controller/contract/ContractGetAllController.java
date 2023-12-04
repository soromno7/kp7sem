package com.example.kp6semserver.controller.car;

import com.example.kp6semserver.model.CarModel;
import com.example.kp6semserver.model.ContractModel;
import com.example.kp6semserver.service.CarService;
import com.example.kp6semserver.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/contract/get-all")
public class ContractGetAllController {

    @Autowired
    private ContractService contractService;
    @GetMapping
    public ArrayList<ContractModel> getAllContracts () {
        return contractService.getAllContracts();
    }

}
