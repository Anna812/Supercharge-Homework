package BankingLogic;

import Helper.FileIO;
import Models.Account;
import Models.Transaction;

import java.util.ArrayList;

public class Logic implements ILogic {
    private Account account;
    private FileIO fileIO;

    public Logic() {
      account = new Account();
      fileIO = new FileIO();
    }

    @Override
    public void deposit(int amount) {
        account.balance = account.balance - amount;
        Transaction newDeposit = new Transaction("Deposit", amount);
        fileIO.writeTransactionsToFile(newDeposit);
    }

    @Override
    public void withdraw(int amount) {

    }

    @Override
    public void transfer(int amount, String account) {

    }

    @Override
    public ArrayList<String> history(String parameter) {
        return null;
    }
}
