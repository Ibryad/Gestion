package com.joza.gestion.web;

import java.time.LocalDate;

public class CostsResponse {

    private LocalDate date;

    private double debit;

    public CostsResponse(LocalDate date, double debit, double credit) {
        this.date = date;
        this.debit = debit;
        this.credit = credit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    private double credit;



}
