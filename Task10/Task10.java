import java.util.Random;
import java.util.Scanner;

public class Task10 {
    static final int RADIX = 36;

    public static void main(String[] args) {

        System.out.println("Введите длину строки для генерации:");
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        if (len <= 0) {
            throw new RuntimeException("Invalid string length (zero or negative)");
        }

        StringBuilder result = new StringBuilder(len);
        Random rand = new Random();

        while (result.length() < len){
            long value = rand.nextLong();
            result.append(Long.toUnsignedString(value, RADIX));
        }

        int generatedLength = result.length();
        if (generatedLength > len){
            result.delete(len, generatedLength);
        }

        String res = result.toString();

        //test length
        try{
            testLen(res, len);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

        System.out.println("Сгенерированная строка:");
        System.out.println(res);
    }

    private static void testLen(String str, int estimatedLength) throws Exception {
        if (str.length() != estimatedLength) {
            throw new Exception("Length of tested string doesn't match the estimated length");
        }
    }
}
