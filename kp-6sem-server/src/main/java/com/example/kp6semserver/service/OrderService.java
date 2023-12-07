package com.example.kp6semserver.service;

import com.example.kp6semserver.entity.DealerEntity;
import com.example.kp6semserver.model.CarModel;
import com.example.kp6semserver.model.OrderModel;
import com.example.kp6semserver.entity.CarEntity;
import com.example.kp6semserver.entity.OrderEntity;
import com.example.kp6semserver.entity.UserEntity;
import com.example.kp6semserver.exception.common.ObjDoesNotExist;
import com.example.kp6semserver.repository.CarRepo;
import com.example.kp6semserver.repository.DealerRepo;
import com.example.kp6semserver.repository.OrderRepo;
import com.example.kp6semserver.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private DealerRepo dealerRepo;

    public OrderEntity create(OrderEntity order, Long userID, Long dealerID, Long carID) {
        UserEntity user = userRepo.findById(userID).get();
        DealerEntity dealer = dealerRepo.findById(dealerID).get();
        CarEntity car = carRepo.findById(carID).get();

        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatTime = new SimpleDateFormat("kk:mm");
        String strDate = formatDate.format(date);
        String strTime = formatTime.format(date);


        order.setUser(user);
        order.setDealer(dealer);
        order.setCar(car);
        order.setOrderDate(strDate);
        order.setOrderTime(strTime);


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

    public Double calculatePrice(Integer tariff, String promocode, Integer days) {
        OrderService orderService = new OrderService();
        String promocode_server = orderService.createPromocode();
        Boolean flag = false;
        if(promocode_server.equals(promocode)) flag = true;
        if(flag) return tariff * days * 0.8;
        return (double) (tariff * days);
    }

    public ArrayList<OrderModel> getAllOrders() { return OrderModel.toModel(orderRepo.findAll());}

    public void deleteOrder(Long id) { orderRepo.deleteById(id);}

    public ArrayList<OrderModel> getOrdersByUser(Long ID) {
        Optional<UserEntity> user = userRepo.findById(ID);

        ArrayList<OrderModel> resArr = new ArrayList<OrderModel>();
        ArrayList<OrderModel> allOrders = OrderModel.toModel(orderRepo.findAll());

        for(OrderModel model : allOrders) {
            if(model.getUserID().equals(user.get().getId())) resArr.add(model);
        }
        return resArr;
    }

    public ArrayList<CarModel> getCarsByDealer(Long dealerID) {
        String dealerName = dealerRepo.findById(dealerID).get().getName();

        ArrayList<CarModel> resArr = new ArrayList<CarModel>();
        ArrayList<CarModel> allCars = CarModel.toModel(carRepo.findAll());

        for(CarModel model : allCars) {
            if(model.getDealer().equals(dealerName)) resArr.add(model);
        }
        return resArr;
    }

//    public OrderEntity update(OrderEntity entity) throws ObjDoesNotExist {
//        return orderRepo.findById(entity.getId())
//                .map(newOrder -> {
//                    newOrder.setOrderDate(entity.getOrderDate());
//                    newOrder.setOrderTime(entity.getOrderTime());
//                    newOrder.setDrivePrice(entity.getDrivePrice());
//                    newOrder.setDriveLength(entity.getDriveLength());
//                    newOrder.setCar(entity.getCar());
//                    newOrder.setUser(entity.getUser());
//                    newOrder.setId(entity.getId());
//                    return orderRepo.save(entity);
//                }).orElseThrow(() -> new ObjDoesNotExist("Заказа не существует"));
//    }

}
