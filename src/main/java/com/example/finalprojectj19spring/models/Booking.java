package com.example.finalprojectj19spring.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
/**
 * @author Karl-Erik Sirkas
 * @ Date 22.03.2023
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Booking extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String dateOfBooking;

    @OneToOne(cascade = CascadeType.MERGE)
    public Car car;

    public LocalDate dateFrom;

    public LocalDate dateTo;

    @OneToOne(cascade = CascadeType.MERGE)
    public Branch branch;

    public String returnBranch;

    public boolean allowBooking;

}