package cuentabancaria;

public class StartApp {
    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(1000, "10/01/2021");
        account.withdraw(500, "13/01/2021");
        account.withdraw(200, "16/01/2021");
        account.transfer(100, 1234567890, "11/01/2021");
        account.printStatements();
    }
}
