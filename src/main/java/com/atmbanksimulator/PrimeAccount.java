package com.atmbanksimulator;

public class PrimeAccount extends BankAccount {

    int overdraftLimit = 1000;
    int withdrawalLimit = 2500;

    public PrimeAccount(String a, String p, int b) {
        super(a, p, b);
    }

    @Override
    public boolean withdraw(double amount) {

        if (amount > withdrawalLimit || getBalance()-amount < -overdraftLimit || amount < 0 ) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}
