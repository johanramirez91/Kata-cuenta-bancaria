package cuentabancaria;
import java.time.LocalDate;

public class Movement {
    private LocalDate date;
    private double balance;
    private double withdraw = 0;
    private double deposit = 0;
    private long account;

    public Movement(LocalDate date, double balance, String operation, double amount) {
        this.date = date;
        this.balance = balance;
        selectOperation(operation, amount);
    }

    public Movement(LocalDate date, double amount, long account, double balance) {
        this.date = date;
        this.balance = balance;
        this.account = account;
        selectOperation("transfer", amount);
    }

    private void selectOperation(String operation, double amount) {
        switch (operation.toLowerCase()) {
            case "deposit" -> deposit = amount;
            case "withdraw" -> withdraw = amount;
            case "transfer" -> withdraw = amount;
            default -> balance = amount;
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public double getDeposit() {
        return deposit;
    }

    public long getAccount() {
        return account;
    }
}
