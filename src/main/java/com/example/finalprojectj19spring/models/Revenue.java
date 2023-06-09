package com.example.finalprojectj19spring.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Karl-Erik Sirkas
 * @ Date 22.03.2023
 */
@Entity
@Data
public class Revenue extends  Return {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int pricePerDay;

    private int usingDays;

    private int percForAdditionalComm;

}