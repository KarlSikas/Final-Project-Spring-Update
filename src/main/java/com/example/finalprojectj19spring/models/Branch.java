package com.example.finalprojectj19spring.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
/**
 * @author Karl-Erik Sirkas
 * @ Date 22.03.2023
 */
@Data
@Entity
public class Branch  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String address;   //address with the city

    private boolean isActive;

}