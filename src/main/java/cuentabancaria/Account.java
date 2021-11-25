package cuentabancaria;

import java.util.ArrayList;
import java.util.Comparator;

public class Account {
    private static final String MESSAGE = "Please, amount must be greater than 0";
    private double totalBalance = 0;
    private ArrayList<Movement> movements = new ArrayList<>();
    private FormatData dateFormat = new FormatData();
    private String summary = "";

    public void deposit(int amount, String date) {
        if (amount <= 0) {
            System.out.println(MESSAGE);
        }
        totalBalance += amount;
        movements.add(new Movement(dateFormat.format(date), totalBalance, "Deposit", amount));
    }

    public void withdraw(int amount, String date) {
        if (amount <= 0) {
            System.out.println(MESSAGE);
        }
        totalBalance -= amount;
        movements.add(new Movement(dateFormat.format(date), totalBalance, "Withdraw", amount));
    }

    public void transfer(int amount, long accountNumber, String date) {
        if (amount <= 0) {
            System.out.println(MESSAGE);
        }
        totalBalance -= amount;
        movements.add(new Movement(dateFormat.format(date), amount, accountNumber, totalBalance));
    }

    public void printStatements() {
        movements.stream().sorted(Comparator.comparing(Movement::getDate).reversed())
                .forEach(item -> accountState(item));
        System.out.format("%7s%14s%10s%12s%14s%12s%12s",
                "Date", "Credit", "Debit", "Balance", "Account #", "\n", summary);
    }

    private void accountState(Movement movement) {
        summary += movement.getDate() + "  |  " + movement.getDeposit() + "       " +
                movement.getWithdraw() + "       " + movement.getBalance()
                + "       " + movement.getAccount() + "\n";
    }
}

