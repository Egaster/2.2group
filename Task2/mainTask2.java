package Task2;

import java.util.Scanner;
import static java.lang.Math.floorMod;
public class mainTask2 {
    public static void main(String[] args) {
        System.out.print("Enter integer: ");
        Scanner number = new Scanner(System.in);
        int a = number.nextInt();
        System.out.print("Result:" +
                "\n%: " + (((a % 360) + 360) % 360) +
                "\nfloorMod(): " + floorMod(a, 360));
    }
}
