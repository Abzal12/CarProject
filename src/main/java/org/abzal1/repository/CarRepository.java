package org.abzal1.repository;

import org.abzal1.model.car.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    @Override
    <S extends Car> S save(S car);

    @Query("SELECT c FROM Car c WHERE c.id = :carId")
    Car findCarById(@Param("carId") Long carId);

    @Query("SELECT c FROM Car c WHERE c.user.id = :userId")
    List<Car> findCarsByUserId(@Param("userId") Long userId);
}
