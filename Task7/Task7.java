import java.util.Scanner;


public class Task7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите 2 числа в пределах от 0 до 65535: ");

        System.out.print("Введите первое число: ");
        int var1 = (int) in.nextLong();

        System.out.print("Введите второе число: ");
        int var2 = (int) in.nextLong();

        final long shift = 0xFFFFFFFFL;

        System.out.printf("Первое число как int: %d , и как long: %10d\n",
                var1, (shift & var1));

        System.out.printf("Второе число как int: %d , и как long: %10d\n",
                var2, (shift & var2));

        int sum = (int) ((shift & var1) + (shift & var2));
        System.out.printf("Сумма чисел как int: %d , и как long: %10d\n",
                sum, (shift & var1) + (shift & var2));

        int diff = (int) ((shift & var1) - (shift & var2));
        System.out.printf("Разность чисел как int: %d , и как long: %10d\n",
                diff, (shift & var1) - (shift & var2));

        int mult = (int) ((shift & var1) * (shift & var2));
        System.out.printf("Произведение чисел как int: %d , и как long: %10d\n",
                mult, (shift & var1) * (shift & var2));

        int div = (int) ((shift & var1) / (shift & var2));
        System.out.printf("Частное чисел как int: %d , и как long: %10d\n",
                div, (shift & var1) / (shift & var2));

        int rem = (int) ((shift & var1) % (shift & var2));
        System.out.printf("Остаток от деления как int: %d , и как long: %10d\n",
                rem, (shift & var1) % (shift & var2));
    }
}
