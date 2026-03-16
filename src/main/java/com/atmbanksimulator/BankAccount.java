package com.atmbanksimulator;

// ===== 📚🌐BankAccount (Domain / Service / Business Logic) =====

// BankAccount class:
// - Stores instance variables for account number, password, and balance
// - Provides methods to withdraw, deposit, check balance, etc.
public class BankAccount {
    private String accNumber = "";
    private String accPasswd = "";
    protected double balance = 0;

    public BankAccount(String a, String p, int b) {
        accNumber = a;
        accPasswd = p;
        balance = b;
    }

    // Withdraw money from this account.
    // Returns true if successful, or false if the amount is negative or exceeds the current balance.
    public boolean withdraw( double amount ) {
        if (amount < 0 || balance < amount) {
            return false;
        } else {
            balance -= amount;  // subtract amount from balance
            return true;
        }
    }

    // deposit the amount of money into this account.
    // Return true if successful,or false if the amount is negative
    public boolean deposit( double amount ) {
        if (amount < 0.0) {
            return false;
        } else {
            balance += amount;  // add amount to balance
            return true;
        }
    }

    public void updateAccPasswd(String passwd) {
        accPasswd = passwd;
    }

    // Getter for the account balance
    // Returns the current balance of this account
    public double getBalance() {
        return balance;
    }
    // Getter for the account number
    public String getAccNumber() {
        return accNumber;
    }
    // Getter for the account password
    public String getAccPasswd() {
        return accPasswd;
    }
}
