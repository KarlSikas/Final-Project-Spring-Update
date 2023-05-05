package com.example.finalprojectj19spring.services;

import com.example.finalprojectj19spring.exceptions.BranchNotFoundException;
import com.example.finalprojectj19spring.exceptions.CarNotFoundException;
import com.example.finalprojectj19spring.models.Branch;
import com.example.finalprojectj19spring.models.Car;

import java.util.List;

/**
 * @author Karl-Erik Sirkas
 * @ Date 22.03.2023
 */
public interface CarService {
    /**
     * To create a new car
     *
     * @param car Car
     */
    void addCar(Car car);

    /**
     * To find a car by modelName
     *
     * @param modelName car modelName
     * @return Car
     */
    Car findCarByModelName(String modelName) throws CarNotFoundException;

    /**
     * To find a car by ID
     *
     * @param id Car ID
     * @return Car
     */
    Car findCarById(Long id) throws CarNotFoundException;




    /**
     * To update on existing Car
     *
     * @param  car Car
     */

    void updateCar(Car car) throws CarNotFoundException;

    /**
     * To find all cars
     *
     * @return a list of Cars
     */
    List<Car> findAllCars();

    /**
     * To delete a Car by ID
     *
     * @param id Car ID
     */
    void deleteCarById(Long id) throws CarNotFoundException;

    /**
     * To restore a Car by ID
     *
     * @param id Car ID
     */
    void restoreCarById(Long id) throws CarNotFoundException;
}