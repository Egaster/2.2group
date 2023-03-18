package lab2.Task9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MoveTo implements ConsoleFunction{
    private final Car car;
    private final Scanner in;
    public MoveTo(Car car, Scanner in){ this.car = car; this.in = in;}
    public int run(){
        System.out.println("Введите количество километров:");
        double kilometers;
        try{
            kilometers = in.nextDouble();
        }
        catch (InputMismatchException e){
            System.out.println("Ошибка! Введено не число");
            in.next();
            return 1;
        }
        car.driveToKilometers(kilometers);
        return 1;
    }
}