package org.abzal1.model.car;

import java.time.LocalDate;

public class CarDTO {
    private Long id;
    private Long userId;
    private CarType carType;
    private String carClass;
    private LocalDate startDate;

    public CarDTO(Long id, Long userId, CarType carType, String carClass, LocalDate startDate) {
        this.id = id;
        this.userId = userId;
        this.carType = carType;
        this.carClass = carClass;
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
