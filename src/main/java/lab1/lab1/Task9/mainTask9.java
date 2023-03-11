package lab1.lab1.Task9;

import java.util.Scanner;

public class mainTask9 {
    public static void main(String[] args) {
        System.out.print("Enter str 1:");
        Scanner a = new Scanner(System.in);
        String str1 = a.nextLine();
        System.out.print("Enter str 2:");
        Scanner b = new Scanner(System.in);
        String str2 = b.nextLine();

        System.out.println(str1.equals(str2));
    }
}
