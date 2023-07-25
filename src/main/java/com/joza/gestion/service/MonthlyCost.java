package com.joza.gestion.service;

import com.joza.gestion.entity.Costs;

public class MonthlyCost {

  private static final String CREDIT = "Credit";
  private static final String DEBIT = "Debit";
  private double montantDebit;
  private double montantCredit;

  public static MonthlyCost from(Costs costs) {
    double montant = costs.getMontant();
    return (CREDIT.equals(costs.getType())) ? new MonthlyCost().setMontantCredit(montant)
        : new MonthlyCost().setMontantDebit(montant);
  }

  public MonthlyCost append(Costs costs) {
    double montant = costs.getMontant();
    if(CREDIT.equals(costs.getType())) {
        this.setMontantCredit(montantCredit + montant);
    }else{
      this.setMontantDebit(montantDebit + montant);
    }
    return this;
  }

  public double getMontantDebit() {
    return montantDebit;
  }

  public MonthlyCost setMontantDebit(double montantDebit) {
    this.montantDebit = montantDebit;
    return this;
  }

  public double getMontantCredit() {
    return montantCredit;
  }

  public MonthlyCost setMontantCredit(double montantCredit) {
    this.montantCredit = montantCredit;
    return this;
  }

}
