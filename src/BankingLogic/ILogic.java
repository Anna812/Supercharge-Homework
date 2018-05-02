package BankingLogic;

import java.util.ArrayList;

public interface ILogic {
    void startTransaction(int amount);
    ArrayList<String> getAccountHistory(String parameter);
}
