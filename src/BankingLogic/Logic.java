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
        account.balance = account.balance + amount;
        Transaction newDeposit = new Transaction("Deposit", amount);
        fileIO.writeTransactionsToFile(newDeposit, account.balance);
    }

    @Override
    public void withdraw(int amount) {
        account.balance = account.balance - amount;
        Transaction newWithdraw = new Transaction("Withdraw", amount);
        fileIO.writeTransactionsToFile(newWithdraw, account.balance);
    }

    @Override
    public void transfer(int amount, String accountToTransfer) {
        account.balance = account.balance - amount;
        Transaction newTransfer = new Transaction("Transfer", amount);
        fileIO.writeTransactionsToFile(newTransfer, account.balance);
    }

    @Override
    public ArrayList<String> history(String parameter) {
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

    public ArrayList<String> getCertainTypeOfTransactions(String typeOfTransaction) {
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
