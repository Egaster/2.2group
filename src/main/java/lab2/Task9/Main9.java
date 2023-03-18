package lab2.Task9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        System.out.println("Введите расход топлива (в км/л):");
        Scanner in = new Scanner(System.in);
        double fuelConsumption;
        try{
            fuelConsumption = in.nextDouble();
        }
        catch (InputMismatchException e){
            System.out.println("Ошибка! Введено не число");
            in.next();
            return;
        }
        if (fuelConsumption <= 0){
            System.out.println("Ошибка! Потребление топлива меньше или равно 0");
            return;
        }
        Car car = new Car(fuelConsumption);
        ControlConsole.start(car, in);
    }
}