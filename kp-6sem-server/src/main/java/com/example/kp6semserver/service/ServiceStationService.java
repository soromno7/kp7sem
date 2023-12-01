package com.example.kp6semserver.service;

import com.example.kp6semserver.entity.ServiceStationEntity;
import com.example.kp6semserver.exception.common.ObjDoesNotExist;
import com.example.kp6semserver.repository.ServiceStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceStationService {
    @Autowired
    private ServiceStationRepo serviceRepo;

    public ServiceStationEntity create (ServiceStationEntity service) { return serviceRepo.save(service);}

    public List<ServiceStationEntity> getAllServices() { return serviceRepo.findAll();}

//    public Double[] getLocation (Long id) {
//        Optional<CarEntity> optionalCar = carRepo.findById(id);
//        CarEntity car = optionalCar.get();
//        return car.getLocation();
//    }

    public void delete(Long id) { serviceRepo.deleteById(id);}

    public ServiceStationEntity update (ServiceStationEntity service) throws ObjDoesNotExist {
        return serviceRepo.findById(service.getId())
                .map(newService -> {
                    newService.setAddress(service.getAddress());
                    newService.setName(service.getName());
                    return serviceRepo.save(service);
                }).orElseThrow(() -> new ObjDoesNotExist("Такого СТО в системе не существует"));
    }
}
