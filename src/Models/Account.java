package Models;

import Helper.FileIO;
import java.util.ArrayList;

public class Account {
    public int balance;

    public Account() {
        balance = getLastBalance();
    }

    private int getLastBalance() {
        FileIO fileIO = new FileIO();
        ArrayList<String> transactionHistory = fileIO.readTransactionsFromFile();
        String lastTransaction = transactionHistory.get(transactionHistory.size());
        String[] lastTransactionSplitted = lastTransaction.split(" ");
        return  Integer.parseInt(lastTransactionSplitted[2]);
    }
}
