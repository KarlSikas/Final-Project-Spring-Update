package com.example.finalprojectj19spring.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;



/**
 * @author Karl-Erik Sirkas
 * @ Date 22.03.2023
 */

@Entity
@Data

public class Rental  extends Booking implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    private Booking booking;

    public String commentsBefore;

    public boolean isActive;

}
