package com.joza.gestion.web;

import com.joza.gestion.service.MonthlyCost;
import java.time.YearMonth;

public class CostsResponse {

    private YearMonth yearMonth;
    private double debit;
    private double credit;


    public CostsResponse(YearMonth yearMonth, double debit, double credit) {
        this.yearMonth = yearMonth;
        this.debit = debit;
        this.credit = credit;
    }

    public CostsResponse(YearMonth yearMonth, MonthlyCost monthlyCost) {
        this.yearMonth = yearMonth;
        this.debit = monthlyCost.getMontantDebit();
        this.credit = monthlyCost.getMontantCredit();
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
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



}
