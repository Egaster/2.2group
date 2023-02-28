import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите 1 целое число: ");
        int a = in.nextInt();

        System.out.print("Введите 2 целое число: ");
        int b = in.nextInt();

        System.out.print("Введите 3 целое число: ");
        int c = in.nextInt();

        //1 способ (условие)
        int max1 = maxNoMath(a, b, c);
        System.out.println("Результат 1 способа: " + max1);

        //2 способ (Math.max())
        int max2 = maxWithMath(a, b, c);
        System.out.println("Результат 2 способа: " + max2);
    }

    private static int maxNoMath (int value1, int... rest){
        int res = value1;
        for (int value : rest){
            if (value > res) {
                res = value;
            }
        }
        return res;
    }

    private static int maxWithMath(int value1, int... rest){
        int res = value1;
        for (int value : rest){
            res = Math.max(res, value);
        }
        return res;
    }

}
