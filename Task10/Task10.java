import java.util.Random;

public class Task10 {
    public static void main(String[] args) {
        Random rand = new Random();
        long value = rand.nextLong();
        String result = Long.toUnsignedString(value, 36);
        System.out.println(result);
    }
}
