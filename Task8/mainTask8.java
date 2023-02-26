package Task8;

import java.util.Scanner;
import java.util.stream.Stream;
public class mainTask8 {
    public static void main(String[] args) {
        System.out.print("Enter string: ");
        Scanner a = new Scanner(System.in);
        String str = a.nextLine();
        Stream.of(str.split("\\s+")).forEach(System.out::println);
    }
}
