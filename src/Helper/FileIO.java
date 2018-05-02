package Helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileIO {
    private static final String filePath = "resources/TransactionHistory.txt";

    public ArrayList<String> readTransactionsFromFile() {
        ArrayList<String> fileContent = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            while (line != null) {
                fileContent.add(line);
                line = br.readLine();
            }
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
