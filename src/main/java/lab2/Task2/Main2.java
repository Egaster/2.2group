package lab2.Task2;

import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        /* Метод nextInt модифицирующий, так как он меняет значение полей объекта*/
        Random random = new Random();
        int s = random.nextInt();
        /* Метод nextInt - метод доступа, так как он не меняет объекта*/
    }

}
