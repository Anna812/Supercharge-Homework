package Helper;

import Models.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileIO {
    private static final String filePath = "resources/TransactionHistory.txt";

    public ArrayList<Transaction> readTransactionsFromFile() {
        ArrayList<Transaction> fileContent = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            while (line != null) {
                String[] splittedLine = line.split(" ");
                Transaction temp = new Transaction(splittedLine[0], Integer.parseInt(splittedLine[1]));
                temp.timeOfTransaction = LocalDateTime.parse(splittedLine[3]);
                fileContent.add(temp);

                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public void writeTransactionsToFile(Transaction transaction, int balance) {
        String transactionData = transaction.type + " " + transaction.amount + " " + balance + " " + transaction.timeOfTransaction;
        List<String> input = Arrays.asList(transactionData);
        Path file = Paths.get(filePath);

        try {
            Files.write(file, input, Charset.forName("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
