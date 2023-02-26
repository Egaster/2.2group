package Task3;

import java.util.ArrayList;
import java.util.Scanner;

public class mainTask3 {
    public static void main(String[] args) {

        int[] myArray;
        myArray = new int[3];

        System.out.print("Enter integer 1: ");
        Scanner number1 = new Scanner(System.in);
        myArray[0] = number1.nextInt();
        System.out.print("Enter integer 2: ");
        Scanner number2 = new Scanner(System.in);
        myArray[1] = number2.nextInt();
        System.out.print("Enter integer 3: ");
        Scanner number3 = new Scanner(System.in);
        myArray[2] = number3.nextInt();

        if (myArray[0] > myArray[1]) {
            if (myArray[0] > myArray[2]) {
                System.out.println("(if)The biggest number: " + myArray[0]);
            }
        } else {
            if (myArray[1] > myArray[2]) {
                System.out.println("(if)The biggest number: " + myArray[1]);
            } else {
                System.out.println("(if)The biggest number: " + myArray[2]);
            }
        }

        int maxMath = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            maxMath = Math.max(maxMath, myArray[i]);
        }
        System.out.println("(Math.max)The biggest number:" + maxMath);
    }
}