package com.atmbanksimulator;

public class StudentAccount extends BankAccount {

    int withdrawalLimit = 1200;

    public StudentAccount(String a, String p, int b) {
        super(a, p, b);
    }

    @Override
    public boolean withdraw(double amount) {

        if (amount > withdrawalLimit || amount < 0.0) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}