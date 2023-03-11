import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str = in.nextLine();
        int[] codepoints = str.codePoints().toArray();
        for (int c : codepoints) {
            if (c > 127) {
                System.out.println("char: " + (char) c + "\tunicode: " + c);
            }
        }
    }
}
