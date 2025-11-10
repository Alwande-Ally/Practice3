package Question2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */
import java.util.List;

public class BankApp {
    public static void main(String[] args) {
        // Create bank and accounts
        Bank bank = new Bank();
        Account a1 = new Account("001", "John Doe", 1000);
        Account a2 = new Account("002", "Jane Smith", 1500);

        // Add accounts to the bank
        bank.addAccount(a1);
        bank.addAccount(a2);

        // Perform some transactions
        a1.deposit(500); // John deposits
        a2.withdraw(200); // Jane withdraws
        a1.withdraw(700); // John withdraws

        // Print account details and transaction history
        System.out.println("Total Bank Balance: R" + bank.totalBankBalance());
        bank.printTransactionHistory();

        // Remove an account and check the new balance
        bank.removeAccount("002");
        System.out.println("Total Bank Balance after removing Jane's account: R" + bank.totalBankBalance());
    }

    private static class Bank {

        public Bank() {
        }

        private void addAccount(Account a1) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String totalBankBalance() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void printTransactionHistory() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void removeAccount(String string) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}

