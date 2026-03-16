package com.atmbanksimulator;

// ===== 📚🌐Bank (Domain / Service / Business Logic) =====

// Bank class: a simple implementation of a bank, containing a list of bank accounts
// and has a currently logged-in account (loggedInAccount).
public class Bank {

    // ToDO: Optional extension:
    // Improve account management in the Bank class:
    // Replace Array with ArrayList for managing BankAccount objects.
    // Refactor addBankAccount and login methods to leverage ArrayList.

    // Instance variables storing bank information
    private int maxAccounts = 10;                       // Maximum number of accounts the bank can hold
    private int numAccounts = 0;                        // Current number of accounts in the bank
    private BankAccount[] accounts = new BankAccount[maxAccounts];  // Array to hold BankAccount objects
    private BankAccount loggedInAccount = null;         // Currently logged-in account ('null' if no one is logged in)

    // a method to create new BankAccount - this is known as a 'factory method' and is a more
    // flexible way to do it than just using the 'new' keyword directly.
    public BankAccount makeBankAccount(String accNumber, String accPasswd, int balance) {
        return new BankAccount(accNumber, accPasswd, balance);
    }

    // a function to check if a given account no is being used or not
    public boolean accountNumberExists(String accNumber) {
        if (numAccounts > 0) {
            for (BankAccount account : accounts) {
                    System.out.println(account);
                if (account != null){
                    if (account.getAccNumber().equals(accNumber)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // a method to add a new bank account to the bank - it returns true if it succeeds
    // or false if it fails (because the bank is 'full')
    public boolean addBankAccount(BankAccount a) {
        if (numAccounts < maxAccounts) {
            if ( !accountNumberExists(a.getAccNumber()) ) {

                accounts[numAccounts] = a;
                numAccounts++ ;
                return true;
            }
        }
        return false;
    }

    // Variant of addBankAccount: creates a BankAccount and adds it in one step.
    // This is an example of method overloading: two methods can share the same name
    // if they have different parameter lists.
    public boolean addBankAccount(String accNumber, String accPasswd, int balance, String accType) {
        return switch (accType) {
            case "1" -> addBankAccount(new PrimeAccount(accNumber, accPasswd, balance));
            case "2" -> addBankAccount(new StudentAccount(accNumber, accPasswd, balance));
            case "3" -> addBankAccount(new SavingsAccount(accNumber, accPasswd, balance));
            default -> false;
        };
    }

    // Check whether the given accountNumber and password match an existing BankAccount.
    // If successful, set 'loggedInAccount' to that account and return true.
    // Otherwise, set 'loggedInAccount' to null and return false.
    public boolean login(String accountNumber, String password) {
        logout(); // logout of any previous loggedInAccount

        // Search the accounts array to find a BankAccount with a matching accountNumber and password.
        // - If found, set 'loggedInAccount' to that account and return true.
        // - If not found, reset 'loggedInAccount' to null and return false.
        for (BankAccount b: accounts) {
            if (b!=null && b.getAccNumber().equals(accountNumber) && b.getAccPasswd().equals(password)) {
                // found the right account
                loggedInAccount = b;
                return true;
            }
        }
        // not found - return false
        loggedInAccount = null;
        return false;
    }

    public String updateAccPasswd(String accountNumber, String passwd) {
        if (passwd.length() == 5) {

            for (BankAccount b : accounts) {
                if (b.getAccNumber().equals(accountNumber)) {
                    b.updateAccPasswd(passwd);
                    return "Success";
                }
            }
            return "Error: Account Not Found!";
        } else {
            return "Error: Invalid Password!";
        }
    }

    // Log out of the currently logged-in account, if any
    public void logout() {
        if (loggedIn()) {
            loggedInAccount = null;
        }
    }

    // Check whether the bank currently has a logged-in account
    public boolean loggedIn() {
        if (loggedInAccount == null) {
            return false;
        } else {
            return true;
        }
    }

    // Attempt to deposit money into the currently logged-in account
    // by calling the deposit method of the BankAccount object
    public boolean deposit(double amount)
    {
        if (loggedIn()) {
            return loggedInAccount.deposit(amount);
        } else {
            return false;
        }
    }


    // Attempt to withdraw money from the currently logged-in account
    // by calling the withdraw method of the BankAccount object
    public boolean withdraw(double amount)
    {
        if (loggedIn()) {
            return loggedInAccount.withdraw(amount);
        } else {
            return false;
        }
    }

    // get the currently logged-in account balance
    // by calling the getBalance method of the BankAccount object
    public double getBalance()
    {
        if (loggedIn()) {
            return loggedInAccount.getBalance();
        } else {
            return -1; // use -1 as an indicator of an error
        }
    }
}