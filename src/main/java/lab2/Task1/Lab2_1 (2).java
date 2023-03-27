import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Lab2_1 {
    public static void method(int dayOfWeek){

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Ввеедите год пожалуйста: ");
        int year = in.nextInt();
        System.out.print("Ввеедите месяц пожалуйста: ");
        int month = in.nextInt();
        LocalDate date = LocalDate.of(year, month, 1);
        System.out.print("Введите номер дня недели, с которого вы хотите начать исчисление календаря: ");
        int numDay = in.nextInt();
        int k = numDay;
        for (int i = 1; i <=7 ; i++) {
            switch (k){
                case 1:
                    System.out.print("Пн");
                    System.out.print("  ");
                    break;
                case 2:
                    System.out.print("Вт");
                    System.out.print("  ");
                    break;
                case 3:
                    System.out.print("Ср");
                    System.out.print("  ");
                    break;
                case 4:
                    System.out.print("Чт");
                    System.out.print("  ");
                    break;
                case 5:
                    System.out.print("Пт");
                    System.out.print("  ");
                    break;
                case 6:
                    System.out.print("Сб");
                    System.out.print("  ");
                    break;
                case 7:
                    System.out.print("Вс");
                    System.out.print("  ");
                    break;
            }
            if (k==7){
                k = 1;
            }
            else k++;
        }
        System.out.println();
        date = date.minusDays(numDay-1);
        DayOfWeek day1 = date.getDayOfWeek();
        int value = day1.getValue();
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        date=date.plusDays(numDay-1);
        while (date.getMonthValue()==month){
            date=date.minusDays(numDay-1);
            DayOfWeek day= date.getDayOfWeek();
            if(day.getValue()%7==0){
                date=date.plusDays(numDay-1);
                System.out.printf("%2d",date.getDayOfMonth());
                System.out.println("  ");}
            else {
                date=date.plusDays(numDay-1);
                System.out.printf("%2d", date.getDayOfMonth());
                System.out.print("  ");
            }
            date = date.plusDays(1);
        }

    }
}
