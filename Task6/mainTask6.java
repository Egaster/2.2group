package Task6;

import java.math.BigInteger;
import java.util.Scanner;
public class mainTask6 {
    public static void main(String[] args) {
        System.out.print("Enter int n:");
        Scanner number = new Scanner(System.in);
        int a = number.nextInt();
        System.out.println("n! = " + factorial(a).toString());
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.valueOf(1); // int преобразуем в BigInteger
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;

    }
}
