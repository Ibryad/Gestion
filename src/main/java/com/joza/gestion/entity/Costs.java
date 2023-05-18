package com.joza.gestion.entity;

import java.sql.Date;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="costs")
public class Costs {
    @Id
    private Long id;
    private Date date;
    private String type;
    private double montant;
    private String description;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
