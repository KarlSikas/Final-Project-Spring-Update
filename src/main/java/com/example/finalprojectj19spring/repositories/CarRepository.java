package com.example.finalprojectj19spring.repositories;

import com.example.finalprojectspring.models.Branch;

import com.example.finalprojectspring.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/23/2023
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {


    Optional<Car> findByModelName(String modelName);

}