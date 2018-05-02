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

    public void startTransaction(int amount, String type) {
        if(type.equalsIgnoreCase("Deposit")) {
            account.balance = account.balance + amount;
        } else {
            account.balance = account.balance - amount;
        }
        Transaction newDeposit = new Transaction(type, amount);
        fileIO.writeTransactionsToFile(newDeposit, account.balance);
    }

    public ArrayList<String> getAccountHistory(String parameter) {
        if(parameter.equals("u")) {
            return fileIO.readTransactionsFromFile();
        } else if (parameter.equalsIgnoreCase("deposit")) {
            return getCertainTypeOfTransactions("Deposit");
        }
        else if (parameter.equalsIgnoreCase("withdraw")) {
            return getCertainTypeOfTransactions("Withdraw");
        }
        else if (parameter.equalsIgnoreCase("transfer")) {
            return getCertainTypeOfTransactions("Transfer");
        }
        else if (parameter.equalsIgnoreCase("desc")) {

        }
        else if (parameter.equalsIgnoreCase("asc")) {

        }
        return null;
    }

    private ArrayList<String> getCertainTypeOfTransactions(String typeOfTransaction) {
        ArrayList<String> history = fileIO.readTransactionsFromFile();
        ArrayList result = new ArrayList();
        for (String temp : history) {
            if(temp.contains(typeOfTransaction)) {
                result.add(temp);
            }
        }
        return result;
    }
}
