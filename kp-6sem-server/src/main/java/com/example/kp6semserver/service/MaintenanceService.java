package com.example.kp6semserver.service;

import com.example.kp6semserver.entity.CarEntity;
import com.example.kp6semserver.entity.DealerEntity;
import com.example.kp6semserver.entity.MaintenanceEntity;
import com.example.kp6semserver.entity.UserEntity;
import com.example.kp6semserver.exception.common.ObjDoesNotExist;
import com.example.kp6semserver.model.CarModel;
import com.example.kp6semserver.model.MaintenanceModel;
import com.example.kp6semserver.repository.CarRepo;
import com.example.kp6semserver.repository.DealerRepo;
import com.example.kp6semserver.repository.MaintenanceRepo;
import com.example.kp6semserver.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {
    @Autowired
    private MaintenanceRepo maintenanceRepo;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CarRepo carRepo;

    public MaintenanceEntity create (MaintenanceEntity maintenance, Long userID, Long carID) {
        CarEntity car = carRepo.findById(carID).get();
        UserEntity user = userRepo.findById(userID).get();

        maintenance.setCar(car);
        maintenance.setUser(user);
        return maintenanceRepo.save(maintenance);
    }

    public List<MaintenanceEntity> getAll() { return maintenanceRepo.findAll();}

    public ArrayList<MaintenanceModel> getAllModels() { return MaintenanceModel.toModel(maintenanceRepo.findAll());}

    public void delete(Long id) { maintenanceRepo.deleteById(id);}

}
