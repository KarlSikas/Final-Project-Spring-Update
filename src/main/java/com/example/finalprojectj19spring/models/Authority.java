package com.example.finalprojectj19spring.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/28/2023
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Authority extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private boolean isActive;
}
