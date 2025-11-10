/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

// LO4: Unit Testing
public class BankTest {

    private Bank bank;
    private Account a1, a2;

    @Before
    public void setUp() {
        bank = new Bank();
        a1 = new Account("001", "John Doe", 1000);
        a2 = new Account("002", "Jane Smith", 1500);
        bank.addAccount(a1);
        bank.addAccount(a2);
    }

    @Test
    public void testDeposit() {
        a1.deposit(500);
        assertEquals(1500, a1.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        assertTrue(a2.withdraw(500));
        assertEquals(1000, a2.getBalance(), 0.001);
        assertFalse(a2.withdraw(2000)); // insufficient
    }

    @Test
    public void testTotalBankBalance() {
        assertEquals(2500, bank.totalBankBalance(), 0.001);
    }

    @Test
    public void testAddRemoveAccount() {
        Account a3 = new Account("003", "Alice Brown", 2000);
        bank.addAccount(a3);
        assertTrue(bank.getAccounts().contains(a3));
        bank.removeAccount("001");
        assertFalse(bank.getAccounts().contains(a1));
    }

    @Test
    public void testRichestAccount() {
        assertEquals(a2, bank.richestAccount());
    }
}

