package cuentabancaria;

public class StartApp {
    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(1000, "10/01/2021");
        account.deposit(2000, "13/01/2021");
        account.withdraw(500, "14/01/2021");
        account.transfer(100, 1234567890, "18/01/2021");
        account.printStatements();
    }
}
