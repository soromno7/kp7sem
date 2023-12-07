package com.example.kp6semserver.controller.order;

import com.example.kp6semserver.entity.DealerEntity;
import com.example.kp6semserver.entity.PriceEntity;
import com.example.kp6semserver.model.OrderModel;
import com.example.kp6semserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/order/get-price")
public class OrderGetPriceController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Double> getPrice (@RequestBody PriceEntity data) {
        return ResponseEntity.ok(orderService.calculatePrice(data.getTariff(), data.getPromocode(), data.getDays()));
    }

}