package com.example.kp6semserver.service;

import com.example.kp6semserver.entity.OrderEntity;
import com.example.kp6semserver.entity.RentalEntity;
import com.example.kp6semserver.model.RentalModel;
import com.example.kp6semserver.repository.OrderRepo;
import com.example.kp6semserver.repository.RentalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepo rentalRepo;

    @Autowired
    private OrderRepo orderRepo;

    public RentalEntity create() {
        RentalEntity rental = new RentalEntity();
        List<OrderEntity> orders = orderRepo.findAll();
        String orderQuantity = String.valueOf(orders.size());
        String orderSum = orderSum(orders);
        String lastOrderTime = orders.get(orders.size() - 1).getOrderTime();

        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("kk:mm");
        String strDate = formatDate.format(date);
        String strTime = formatTime.format(date);

        rental.setRentalDate(strDate);
        rental.setRentalTime(strTime);
        rental.setOrderQuantity(orderQuantity);
        rental.setOrderSum(orderSum);
        rental.setLastOrderTime(lastOrderTime);

        return rentalRepo.save(rental);
    }

    public String orderSum(List<OrderEntity> orders){
        double sum = 0;

        for(OrderEntity entity : orders) {
            sum += Double.parseDouble(entity.getDrivePrice());
        }

        return String.valueOf(sum);
    }

    public ArrayList<RentalModel> getAllRentals() { return RentalModel.toModel(rentalRepo.findAll());}

    public void delete(Long id) { rentalRepo.deleteById(id);}


}
