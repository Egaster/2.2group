package lab2.Task13;


import com.opencsv.CSVReader;

import java.io.FileReader;
import java.time.LocalDateTime;

public class Main13 {
    private static final String PATH = "D:\\Study\\6 семестр\\Java Projects\\2.2group\\src\\main\\java\\lab2\\Task13\\addresses.csv";

    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(PATH));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            for (String e : nextLine) {
                System.out.format("%s ", e);
            }
        }
    }
}