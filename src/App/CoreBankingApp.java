package App;

import java.util.Scanner;

public class CoreBankingApp {
    static Scanner userInput =  new Scanner(System.in);

    public static void main(String[] args) {
        String info = "Welcome at your core banking service. Type \"d\" to deposit money. \n" +
                "Type \"w\" to withdraw money. \n" +
                "Type \"t\" to transfer money. \n" +
                "Type \"h\" to see your accounts history. \n" +
                "Type \"q\" to stop the program";

        System.out.println(info);
        while(userInput.hasNext()) {
            String input = userInput.next();
            if(input.equals("d")){
                //deposit logic
            } else if (input.equals("w")) {
                // withdraw logic
            } else if (input.equals("t")) {
                // transfer logic
            } else if (input.equals("h")) {
                // history logic
            } else if (input.equals("q")) {
                System.out.println("Thank you for using our service!");
                break;
            } else {
                System.out.println(info);
            }
        }
    }
}
