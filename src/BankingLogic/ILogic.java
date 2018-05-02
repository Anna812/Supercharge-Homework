package BankingLogic;

import java.util.ArrayList;

public interface ILogic {
    void startTransaction(int amount, String type);
    ArrayList<String> getAccountHistory(String parameter);
}
