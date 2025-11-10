
import Question2.Transaction;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

// LO1: Account class
public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getters and setters
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }

    public void setAccountHolder(String accountHolder) { this.accountHolder = accountHolder; }
    public void setBalance(double balance) { this.balance = balance; }

    // Deposit money
    public void deposit(double amount) {
        if(amount > 0) balance += amount;
    }

    // Withdraw money (only if sufficient balance)
    public boolean withdraw(double amount) {
        if(amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Display account information
    @Override
    public String toString() {
        return "Account " + accountNumber + " - " + accountHolder + " - Balance: R" + balance;
    }

    Iterable<Transaction> getTransactions() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
