package Task10;

import java.util.Random;

public class mainTask10 {
    public static void main(String[] args) {
        Random rand = new Random();
        long a = rand.nextLong();
        System.out.print(Long.toUnsignedString(a, 36));
    }
}