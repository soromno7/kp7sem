package com.example.kp6semserver.controller.contract;

import com.example.kp6semserver.entity.CarEntity;
import com.example.kp6semserver.entity.ContractEntity;
import com.example.kp6semserver.exception.common.ObjAlreadyExists;
import com.example.kp6semserver.service.CarService;
import com.example.kp6semserver.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/contract/add")
public class ContractCreateController {

    @Autowired
    private ContractService contractService;

    @PostMapping("/{orderID}")
    public ResponseEntity create(@RequestBody ContractEntity contract,
                                 @PathVariable Long orderID)
    {
        try {
            return ResponseEntity.ok(contractService.create(contract, orderID));
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка: " + e.getMessage());
        }
    }


}
