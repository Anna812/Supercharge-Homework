package Models;

import java.time.LocalDateTime;

public class Transaction {
    public String type;
    public int amount;
    public LocalDateTime timeOfTransaction;

    public Transaction(String type, int amount) {
        this.type = type;
        this.amount = amount;
        timeOfTransaction = LocalDateTime.now();
    }
}
