package BankingLogic;

import Models.Account;

import java.util.ArrayList;

public class Logic implements ILogic {
    private Account account;

    public Logic() {
      account = new Account();
    }

    @Override
    public void deposit(int amount) {

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
