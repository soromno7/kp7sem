package com.example.kp6semserver.controller.contract;

import com.example.kp6semserver.entity.ContractPriceEntity;
import com.example.kp6semserver.entity.PriceEntity;
import com.example.kp6semserver.service.ContractService;
import com.example.kp6semserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/contract/get-price")
public class ContractCalculatePriceController {
    @Autowired
    private ContractService contractService;

    @PostMapping
    public ResponseEntity<Integer> getPrice (@RequestBody ContractPriceEntity data) {
        return ResponseEntity.ok(contractService.calculateContractPrice(data));
    }

}