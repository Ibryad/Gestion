package com.joza.gestion.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="costs")
public class Costs {
    @Id
    private Long id;
    private Date date;
    private String type;
    private double montant;
    private String description;

    public Costs() {

    }

    public Costs(Long id, Date date, String type, double montant, String description) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.montant = montant;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
