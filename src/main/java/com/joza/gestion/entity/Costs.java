package com.joza.gestion.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="costs")
public class Costs {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private String type;
    private double montant;
    private String description;

    public Costs() {

    }

    public Costs(Integer id, LocalDate date, String type, double montant, String description) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.montant = montant;
        this.description = description;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
