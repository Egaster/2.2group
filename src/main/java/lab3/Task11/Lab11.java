package lab3.Task11;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

public class Lab11 {

    private static String[] takeFiles(Path path) {
        File file = path.toFile();
        return file.list();
    }

    private static String[] takeFilesWithLambda(Path path, String extension) {
        File file = path.toFile();
        return file.list((s, b) -> b.contains(".") && b.split("\\.")[1].equals(extension));
    }

    public static void main(String[] args) {
        Path path = Path.of("D:\\Study\\6 семестр\\Java Projects\\2.2group\\src\\main\\java\\lab3");
        System.out.println(Arrays.toString(takeFiles(path)));
        System.out.println(Arrays.toString(takeFilesWithLambda(path, "java")));
    }
}
