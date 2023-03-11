package lab1.lab1.Task8;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        System.out.println("Введите строку:");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println("Все подстроки введенной строки:");
        for (int i = 0; i < s.length(); i++){
            for (int j = i+1; j <= s.length(); j++){
                System.out.println(s.substring(i,j));
            }
        }
    }
}
