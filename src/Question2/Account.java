/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question2;

/**
 *
 * @author lab_services_student
 */
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<Transaction> transactions; // List to store transactions

    // Constructor
    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    // Method to deposit money
    public void deposit(double amount) {
        this.balance += amount;
        transactions.add(new Transaction(accountNumber, amount, "deposit"));
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
            transactions.add(new Transaction(accountNumber, amount, "withdrawal"));
            return true;
        }
        return false;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

