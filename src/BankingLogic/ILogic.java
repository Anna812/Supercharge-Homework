package BankingLogic;

import java.util.ArrayList;

public interface ILogic {
    void deposit(int amount);
    void withdraw(int amount);
    void transfer(int amount, String account);
    ArrayList<String> history(String parameter);
}
