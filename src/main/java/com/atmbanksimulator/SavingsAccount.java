package com.atmbanksimulator;

public class SavingsAccount extends BankAccount {

    double interestRate = 1.05;

    public SavingsAccount(String a, String p, int b) {
        super(a, p, b);
    }

    public void addInterest(){
        balance *= interestRate;
    }
}
