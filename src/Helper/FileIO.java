package Helper;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileIO {
    private static final String filePath = "resources/TransactionHistory.txt";
    
    public String readTransactionsFromFile() {
        String fileContent = "";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            fileContent = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public void writeTransactionsToFile() {

    }
}
