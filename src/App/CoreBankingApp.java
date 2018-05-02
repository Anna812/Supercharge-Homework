package App;

import BankingLogic.Logic;

import java.util.ArrayList;
import java.util.Scanner;

public class CoreBankingApp {
    static Scanner userInput =  new Scanner(System.in);

    public static void main(String[] args) {
        Logic logic = new Logic();
        String info = "Welcome at your core banking service. Type \"d\" to deposit money. \n" +
                "Type \"w\" to withdraw money. \n" +
                "Type \"t\" to transfer money. \n" +
                "Type \"h\" to see your accounts history. \n" +
                "Type \"q\" to stop the program";

        System.out.println(info);
        while(userInput.hasNext()) {
            String input = userInput.next();
            if(input.equals("d")){
                System.out.println("Type the amount you want to deposit, please.");
                int amount = Integer.parseInt(userInput.next());
                logic.deposit(amount);
            } else if (input.equals("w")) {
                System.out.println("Type the amount you want to withdraw, please.");
                int amount = Integer.parseInt(userInput.next());
                logic.withdraw(amount);
            } else if (input.equals("t")) {
                System.out.println("Type the amount you want to transfer, please.");
                int amount = Integer.parseInt(userInput.next());
                System.out.println("Type the account you want to transfer to, please.");
                logic.transfer(amount, userInput.next());
            } else if (input.equals("h")) {
                System.out.printf("If you want an unsorted history, type \"u\".");
                System.out.printf("If you want to sort account history by type of transaction, please write that given transaction type e.g. deposit, withdraw, transfer.");
                System.out.printf("If you want  to sort account history by date, please write \"Desc\" if you want a descending order os \"Asc\" if you want to see an ascending order");
                ArrayList<String> accountHistory = logic.getAccountHistory(userInput.next());
                for (String temp : accountHistory) {
                    System.out.println(temp);
                }
            } else if (input.equals("q")) {
                System.out.println("Thank you for using our service!");
                break;
            } else {
                System.out.println(info);
            }
        }
    }
}
