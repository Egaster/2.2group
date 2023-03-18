package lab2.Task9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FillFuel implements ConsoleFunction {
    private final Car car;
    private final Scanner in;
    public FillFuel(Car car, Scanner in){ this.car = car; this.in = in; }
    public int run(){
        System.out.println("Введите количество топлива, на которое вы хотите пополнить бак");
        double amount;
        try{
            amount = in.nextDouble();
        }
        catch (InputMismatchException e){
            System.out.println("Ошибка! Введено не число");
            in.next();
            return 2;
        }
        if (amount < 0){
            System.out.println("Ошибка! Отрицательное число");
            return 2;
        }
        car.fillFuel(amount);
        return 2;
    }
}
