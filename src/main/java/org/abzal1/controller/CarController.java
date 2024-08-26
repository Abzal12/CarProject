package org.abzal1.controller;

import org.abzal1.model.car.Car;
import org.abzal1.model.car.CarDTO;
import org.abzal1.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car/get-car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/by-car-id")
    public ResponseEntity<CarDTO> getCarById(@RequestParam Long id) {
        Car car = carService.getCarById(id);
        if (car != null) {
            carService.printCustomConditionalBean();
            CarDTO carDTO = new CarDTO(
                    car.getId(),
                    car.getUser().getId(),
                    car.getCarType(),
                    car.getCarClass(),
                    car.getStartDate()
            );
            return new ResponseEntity<>(carDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/by-user-id")
    public ResponseEntity<List<CarDTO>> getCarByUserId(@RequestParam Long id) {
        List<Car> cars = carService.getCarsByUserId(id);
        if (!cars.isEmpty()) {
            carService.printCustomConditionalBean();
            List<CarDTO> carDTOS = cars.stream()
                    .map(car -> new CarDTO(
                            car.getId(),
                            car.getUser().getId(),
                            car.getCarType(),
                            car.getCarClass(),
                            car.getStartDate()
                    ))
                    .toList();

            return new ResponseEntity<>(carDTOS, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
