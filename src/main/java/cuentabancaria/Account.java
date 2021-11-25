package cuentabancaria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account {
    private double totalBalance = 0;
    private ArrayList<Movement> movement = new ArrayList<>();
    private String summary = "";
    private final String MESSAGE = "Please, amount must be greater than 0";

    public void deposit(int amount, String date) {
        if (amount <= 0) {
            System.out.println(MESSAGE);
        }
        totalBalance += amount;
        movement.add(new Movement(dateFormat(date), totalBalance, "Deposit", amount));
    }

    public void withdraw(int amount, String date) {
        if (amount <= 0) {
            System.out.println(MESSAGE);
        }
        totalBalance -= amount;
        movement.add(new Movement(dateFormat(date), totalBalance, "Withdraw", amount));
    }

    public void transfer(int amount, long accountNumber, String date) {
        if (amount <= 0) {
            System.out.println(MESSAGE);
        }
        totalBalance -= amount;
        movement.add(new Movement(dateFormat(date), amount, accountNumber, totalBalance));
    }

    void printStatements() {
        movement.stream().forEachOrdered(movement -> accountState(movement));
        System.out.format("%7s%14s%10s%12s%14s%12s%12s", "Date", "Credit", "Debit", "Balance", "Account #", "\n", summary);
    }

    public void accountState(Movement movement) {
        summary += movement.getDate() + "  |  " + movement.getDeposit() + "       " +
                movement.getWithdraw() + "       " + movement.getBalance()
                + "       " + movement.getAccount() + "\n";
    }

    public LocalDate dateFormat(String date) {
        date = date.replace('/', '-');
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}

