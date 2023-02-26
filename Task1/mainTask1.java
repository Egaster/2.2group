package Task1;

import java.util.Scanner;

/**
 * Write a program that reads an integer and prints it in binary, octal, and hexadecimal.
 * Print the reciprocal as a hexadecimal floating-point number
 */
public class mainTask1 {
    public static void main(String[] args) {
        System.out.print("Enter int number: ");
        Scanner num = new Scanner(System.in);
        int num10 = num.nextInt();

        // Бинарный формат
        System.out.print("2: ");
        String convert = Integer.toBinaryString(num10);
        System.out.println(convert);

        // Восьмиричная форма
        System.out.print("8: ");
        convert = Integer.toOctalString(num10);
        System.out.println(convert);

        // Шеснадцатиричная форма
        System.out.print("16: ");
        convert = Integer.toHexString(num10).toUpperCase();
        System.out.println(convert);

        // Шеснадцатиричная форма обратного числа
        System.out.println("16(reverse): " + Double.toHexString((double)1/num10));
    }
}