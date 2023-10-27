package com.example.kp6semserver.service;

import com.example.kp6semserver.model.OrderModel;
import com.example.kp6semserver.entity.CarEntity;
import com.example.kp6semserver.entity.OrderEntity;
import com.example.kp6semserver.entity.UserEntity;
import com.example.kp6semserver.exception.common.ObjDoesNotExist;
import com.example.kp6semserver.repository.CarRepo;
import com.example.kp6semserver.repository.OrderRepo;
import com.example.kp6semserver.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CarRepo carRepo;

    public OrderEntity create(OrderEntity order, Long userID, Long carID) {
        UserEntity user = userRepo.findById(userID).get();
        CarEntity car = carRepo.findById(carID).get();

        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("kk:mm");
        String strDate = formatDate.format(date);
        String strTime = formatTime.format(date);

        String tariff = car.getTariff();
        String[] driveLengthDelimited = order.getDriveLength().split(":");

        OrderService orderService = new OrderService();
        String promocode = orderService.createPromocode();
        Boolean flag = false;
        if(promocode.equals(order.getPromocode())) flag = true;

        String drivePrice = calculatePrice(driveLengthDelimited, tariff, flag);

        order.setUser(user);
        order.setCar(car);
        order.setOrderDate(strDate);
        order.setOrderTime(strTime);
        order.setDrivePrice(drivePrice);

        return orderRepo.save(order);
    }

    public String createPromocode() {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("EEEE", Locale.US);
        String strDate = formatDate.format(date).trim();

        String promocode = "";

        if(strDate.equals("Monday")){promocode = "MNDAY";}
        if(strDate.equals("Tuesday")){promocode = "TSDAY";}
        if(strDate.equals("Wednesday")){promocode = "WSDAY";}
        if(strDate.equals("Thursday")){promocode = "THDAY";}
        if(strDate.equals("Friday")){promocode = "FRDAY";}
        if(strDate.equals("Saturday")){promocode = "STDAY";}
        if(strDate.equals("Sunday")){promocode = "SNDAY";}

        return promocode;
    }

    public String calculatePrice(String[] driveLength, String tariff, Boolean flag) {
        double coef = 0;
        double startPrice = 2.5;

        if(tariff == "Комфорт"){
            startPrice *= 1.5;
            coef = 0.05;
        }
        if(tariff == "Бизнес"){
            startPrice *= 2;
            coef = 0.01;
        }
        else{
            coef = 0.0025;
        }

        Byte hB = Byte.valueOf(driveLength[0]);
        Byte mB = Byte.valueOf(driveLength[1]);
        Byte sB = Byte.valueOf(driveLength[2]);

        double h = (double) hB;
        double m = (double) mB;
        double s = (double) sB;

        double time = h * 3600 + m * 60 + s;

        if(flag) return String.valueOf((time * coef + startPrice) * 0.7);
        return String.valueOf(time * coef + startPrice);
    }

    public ArrayList<OrderModel> getAllOrders() { return OrderModel.toModel(orderRepo.findAll());}

    public void deleteOrder(Long id) { orderRepo.deleteById(id);}

    public OrderEntity update(OrderEntity entity) throws ObjDoesNotExist {
        return orderRepo.findById(entity.getId())
                .map(newOrder -> {
                    newOrder.setOrderDate(entity.getOrderDate());
                    newOrder.setOrderTime(entity.getOrderTime());
                    newOrder.setDrivePrice(entity.getDrivePrice());
                    newOrder.setDriveLength(entity.getDriveLength());
                    newOrder.setCar(entity.getCar());
                    newOrder.setUser(entity.getUser());
                    newOrder.setId(entity.getId());
                    return orderRepo.save(entity);
                }).orElseThrow(() -> new ObjDoesNotExist("Заказа не существует"));
    }

}
