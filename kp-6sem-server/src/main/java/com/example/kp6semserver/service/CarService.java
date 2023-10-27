package com.example.kp6semserver.service;

import com.example.kp6semserver.entity.CarEntity;
import com.example.kp6semserver.exception.common.ObjDoesNotExist;
import com.example.kp6semserver.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;

    public CarEntity registration (CarEntity car) { return carRepo.save(car);}

    public List<CarEntity> getAllCars() { return carRepo.findAll();}

    public Double[] getLocation (Long id) {
        Optional<CarEntity> optionalCar = carRepo.findById(id);
        CarEntity car = optionalCar.get();
        return car.getLocation();
    }

    public void deleteCar(Long id) { carRepo.deleteById(id);}

    public CarEntity update (CarEntity car) throws ObjDoesNotExist {
        return carRepo.findById(car.getId())
                .map(newCar -> {
                    newCar.setBrand(car.getBrand());
                    newCar.setEngineCapacity(car.getEngineCapacity());
                    newCar.setIsMaintained(car.getIsMaintained());
                    newCar.setName(car.getName());
                    newCar.setPlateNumber(car.getPlateNumber());
                    newCar.setSeatsQuantity(car.getSeatsQuantity());
                    newCar.setStereo(car.getStereo());
                    newCar.setTariff(car.getTariff());
                    newCar.setYear(car.getYear());
                    newCar.setLocation(car.getLocation());
                    return carRepo.save(car);
                }).orElseThrow(() -> new ObjDoesNotExist("Такого автомобиля в системе не существует"));
    }
}
