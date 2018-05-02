import java.util.List;

public interface ILogic {
    void deposit(int amount);
    void withdraw(int amount);
    void transfer(int amount, String account);
    List<String> history(String parameter);
}
