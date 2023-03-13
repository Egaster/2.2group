package lab2.Task16;

import java.io.PrintStream;
import java.util.Scanner;

public class Main16 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add();

        queue.print();

        System.out.println();
        System.out.println(queue.remove());

        System.out.println();
        queue.print();
    }
}