package org.abzal1.service;

import org.abzal1.repository.CarRepository;
import org.abzal1.model.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    @Autowired(required = false)
    private final String thisIsMyFirstConditionalBean;

    public CarService(CarRepository carRepository, String thisIsMyFirstConditionalBean) {
        this.carRepository = carRepository;
        this.thisIsMyFirstConditionalBean = thisIsMyFirstConditionalBean;
    }

    @Transactional
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Transactional
    public Car getCarById(Long carId) {
        return carRepository.findCarById(carId);
    }

    @Transactional
    public List<Car> getCarsByUserId(Long userId) {
        return carRepository.findCarsByUserId(userId);
    }

    @Transactional
    public void printCustomConditionalBean() {
        System.out.println(thisIsMyFirstConditionalBean);
    }
}

