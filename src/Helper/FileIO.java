package Helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

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

    public void writeTransactionsToFile(String transaction) {
        List<String> input = Arrays.asList(transaction);
        Path file = Paths.get(filePath);
        
        try {
            Files.write(file, input, Charset.forName("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
