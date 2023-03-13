package lab2.Task13;


import com.opencsv.CSVReader;

import java.io.FileReader;
import java.time.LocalDateTime;

public class Main13 {
    private static final String PATH = "C:\\Users\\egast\\IdeaProjects\\lab2\\src\\main\\java\\lab2\\Task13\\addresses.csv";

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