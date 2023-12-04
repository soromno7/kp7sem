package com.example.kp6semserver.controller.contract;

import com.example.kp6semserver.service.CarService;
import com.example.kp6semserver.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/contract/delete")
public class ContractDeleteController {

    @Autowired
    private ContractService contractService;

    @DeleteMapping("/{id}")
    void deleteCar(@PathVariable Long id) {
        contractService.deleteContract(id);
    }

}
