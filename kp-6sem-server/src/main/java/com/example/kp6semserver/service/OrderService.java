package com.example.kp6semserver.service;

import com.example.kp6semserver.entity.*;
import com.example.kp6semserver.model.CarModel;
import com.example.kp6semserver.model.OrderModel;
import com.example.kp6semserver.exception.common.ObjDoesNotExist;
import com.example.kp6semserver.repository.*;
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
    @Autowired
    private ContractRepo contractRepo;

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

    public OrderModel getLastOrder(Long ID) {
        Optional<UserEntity> user = userRepo.findById(ID);

        OrderModel lastOrder = new OrderModel();
        ArrayList<OrderModel> allOrders = OrderModel.toModel(orderRepo.findAll());

        for(OrderModel model : allOrders) {
            if(model.getUserID().equals(user.get().getId())) lastOrder = model;
        }
        return lastOrder;
    }

    public OrderEntity update(Long OrderID, Long contractID) throws ObjDoesNotExist {
        ContractEntity contract = contractRepo.findById(contractID).get();
        OrderEntity order = orderRepo.findById(OrderID).get();
        return orderRepo.findById(OrderID)
                .map(newOrder -> {
                    newOrder.setContract(contract);
                    return orderRepo.save(order);
                }).orElseThrow(() -> new ObjDoesNotExist("Заказа не существует"));
    }

}
