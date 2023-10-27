package com.example.kp6semserver.controller.order;

import com.example.kp6semserver.entity.OrderEntity;
import com.example.kp6semserver.entity.UserEntity;
import com.example.kp6semserver.exception.common.ObjDoesNotExist;
import com.example.kp6semserver.service.OrderService;
import com.example.kp6semserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/order/update")
public class OrderUpdateController {

    @Autowired
    private OrderService orderService;

    @PutMapping("/{id}")
    OrderEntity updateOrder(@RequestBody OrderEntity order, @PathVariable Long id) throws ObjDoesNotExist {
        return orderService.update(order);
    }

}
