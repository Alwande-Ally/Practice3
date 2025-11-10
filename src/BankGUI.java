/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */

import javax.swing.*;
import java.awt.*;

// LO3: GUI for Bank System
public class BankGUI extends JFrame {

    private Bank bank;
    private JComboBox<String> accountComboBox;
    private JTextField amountTextField;
    private JTextArea reportTextArea;
    private JButton depositButton, withdrawButton, totalButton, clearButton;

    public BankGUI() {
        bank = new Bank();

        // Sample accounts
        bank.addAccount(new Account("001", "John Doe", 1000));
        bank.addAccount(new Account("002", "Jane Smith", 1500));

        setTitle("Bank Account System");
        setSize(550, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ===== Top Panel =====
        JPanel topPanel = new JPanel(new GridLayout(3, 2, 5, 5));

        topPanel.add(new JLabel("Select Account:"));
        accountComboBox = new JComboBox<>();
        refreshAccountComboBox();
        topPanel.add(accountComboBox);

        topPanel.add(new JLabel("Amount:"));
        amountTextField = new JTextField();
        topPanel.add(amountTextField);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        totalButton = new JButton("Show Total");
        clearButton = new JButton("Clear");

        topPanel.add(depositButton);
        topPanel.add(withdrawButton);
        topPanel.add(totalButton);
        topPanel.add(clearButton);

        // ===== Report Area =====
        reportTextArea = new JTextArea();
        reportTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportTextArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // ===== Event Handling =====
        depositButton.addActionListener(e -> deposit());
        withdrawButton.addActionListener(e -> withdraw());
        totalButton.addActionListener(e -> showReport());
        clearButton.addActionListener(e -> clearFields());
    }

    private void refreshAccountComboBox() {
        accountComboBox.removeAllItems();
        for(Account a : bank.getAccounts()) accountComboBox.addItem(a.getAccountHolder() + " (" + a.getAccountNumber() + ")");
    }

    private Account getSelectedAccount() {
        int index = accountComboBox.getSelectedIndex();
        if(index < 0) return null;
        return bank.getAccounts().get(index);
    }

    private void deposit() {
        try {
            Account a = getSelectedAccount();
            double amount = Double.parseDouble(amountTextField.getText());
            a.deposit(amount);
            JOptionPane.showMessageDialog(this, "Deposit successful!");
            showReport();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid amount.");
        }
    }

    private void withdraw() {
        try {
            Account a = getSelectedAccount();
            double amount = Double.parseDouble(amountTextField.getText());
            if(a.withdraw(amount)) {
                JOptionPane.showMessageDialog(this, "Withdrawal successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient balance.");
            }
            showReport();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid amount.");
        }
    }

    private void showReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bank Report:\n");
        int i = 1;
        for(Account a : bank.getAccounts()) {
            sb.append(i++).append(". ").append(a).append("\n");
        }
        sb.append("Total money in bank: R").append(bank.totalBankBalance()).append("\n");
        Account richest = bank.richestAccount();
        if(richest != null) sb.append("Richest Account: ").append(richest.getAccountHolder())
                .append(" - Balance: R").append(richest.getBalance()).append("\n");

        reportTextArea.setText(sb.toString());
    }

    private void clearFields() {
        amountTextField.setText("");
        reportTextArea.setText("");
        accountComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankGUI().setVisible(true));
    }
}

