package BankingLogic;

import Models.Transaction;

import java.util.ArrayList;

public interface ILogic {
    void startTransaction(int amount, String type);
    ArrayList<Transaction> getAccountHistory(String parameter);
}
