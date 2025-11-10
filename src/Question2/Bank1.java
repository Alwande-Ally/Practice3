package Question2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */

import Question2.Transaction;
import java.util.ArrayList;
import java.util.List;

public class Bank1 {
    private List<Account> accounts;

    // Constructor
    public Bank1() {
        accounts = new ArrayList<>();
    }

    // Add account
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Remove account
    public boolean removeAccount(String accountNumber) {
        return accounts.removeIf(account -> account.getAccountNumber().equals(accountNumber));
    }

    // Get all accounts
    public List<Account> getAccounts() {
        return accounts;
    }

    // Total bank balance
    public double totalBankBalance() {
        return accounts.stream().mapToDouble(Account::getBalance).sum();
    }

    // Get transaction history for all accounts
    public void printTransactionHistory() {
        for (Account account : accounts) {
            System.out.println("Transaction History for Account " + account.getAccountNumber() + ":");
            for (Transaction t : account.getTransactions()) {
                System.out.println(t);
            }
        }
    }
}

