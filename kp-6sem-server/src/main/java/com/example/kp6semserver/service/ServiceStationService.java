package com.example.kp6semserver.service;

import com.example.kp6semserver.entity.CarEntity;
import com.example.kp6semserver.entity.DealerEntity;
import com.example.kp6semserver.entity.ServiceStationEntity;
import com.example.kp6semserver.exception.common.ObjDoesNotExist;
import com.example.kp6semserver.model.CarModel;
import com.example.kp6semserver.model.ServiceStationModel;
import com.example.kp6semserver.repository.DealerRepo;
import com.example.kp6semserver.repository.ServiceStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceStationService {
    @Autowired
    private ServiceStationRepo serviceRepo;

    @Autowired
    private DealerRepo dealerRepo;

    public ServiceStationEntity create (ServiceStationEntity station, Long dealerID) {
        DealerEntity dealer = dealerRepo.findById(dealerID).get();

        station.setDealer(dealer);
        return serviceRepo.save(station);
    }

    public ArrayList<ServiceStationModel> getAllServices() { return ServiceStationModel.toModel(serviceRepo.findAll());}

//    public Double[] getLocation (Long id) {
//        Optional<CarEntity> optionalCar = carRepo.findById(id);
//        CarEntity car = optionalCar.get();
//        return car.getLocation();
//    }

    public void delete(Long id) { serviceRepo.deleteById(id);}

    public ServiceStationEntity update (ServiceStationEntity service) throws ObjDoesNotExist {
        return null;
//        return serviceRepo.findById(service.getId())
//                .map(newService -> {
//                    newService.setAddress(service.getAddress());
//                    newService.setName(service.getName());
//                    return serviceRepo.save(service);
//                }).orElseThrow(() -> new ObjDoesNotExist("Такого СТО в системе не существует"));
    }
}
