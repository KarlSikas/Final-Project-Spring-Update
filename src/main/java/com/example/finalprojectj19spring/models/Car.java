package com.example.finalprojectj19spring.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Karl-Erik Sirkas
 * @ Date 22.03.2023
 */
@Data
@Entity

public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String modelName;

    private String color;

    private String bodyType;

    private int yearOfProd;

    private int mileage;

    @OneToOne(cascade = CascadeType.MERGE)
    private Branch branch;

    private  boolean isBooked;

    private String imgUrl;
}