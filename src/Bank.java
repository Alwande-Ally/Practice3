/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */
import java.util.ArrayList;

// LO2: Bank manages multiple accounts
public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    // Add account
    public void addAccount(Account a) {
        accounts.add(a);
    }

    // Remove account by account number
    public boolean removeAccount(String accountNumber) {
        return accounts.removeIf(a -> a.getAccountNumber().equals(accountNumber));
    }

    // Get all accounts
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    // Total money in bank
    public double totalBankBalance() {
        double total = 0;
        for(Account a : accounts) total += a.getBalance();
        return total;
    }

    // Find richest account
    public Account richestAccount() {
        if(accounts.isEmpty()) return null;
        Account richest = accounts.get(0);
        for(Account a : accounts) {
            if(a.getBalance() > richest.getBalance()) richest = a;
        }
        return richest;
    }
}
