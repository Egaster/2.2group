package lab2.Task1;

import java.sql.SQLOutput;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Ввеедите год пожалуйста: ");
        int year = in.nextInt();
        System.out.print("Ввеедите месяц пожалуйста: ");
        int month = in.nextInt();
        LocalDate date = LocalDate.of(year, month, 1);
        System.out.print("Вс");
        System.out.print("  ");
        System.out.print("Пн");
        System.out.print("  ");
        System.out.print("Вт");
        System.out.print("  ");
        System.out.print("Ср");
        System.out.print("  ");
        System.out.print("Чт");
        System.out.print("  ");
        System.out.print("Пт");
        System.out.print("  ");
        System.out.println("Сб");
        date = date.plusDays(1);
        DayOfWeek day1 = date.getDayOfWeek();
        int value = day1.getValue();
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        date=date.minusDays(1);
        while (date.getMonthValue()==month){
            date=date.plusDays(1);
            DayOfWeek day= date.getDayOfWeek();
            if(day.getValue()%7==0){
                date=date.minusDays(1);
                System.out.printf("%2d",date.getDayOfMonth());
                System.out.println("  ");}
            else {
                date=date.minusDays(1);
                System.out.printf("%2d", date.getDayOfMonth());
                System.out.print("  ");
            }
            date = date.plusDays(1);
        }

    }
}
