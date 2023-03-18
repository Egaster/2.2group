package lab2.Task9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlConsole {
    private static final String[] messages = {
            "0. Выход из программы",
            "1. Проехать на заданное количество километров (положительное число для движения по оси X, отрицательное число - для движения против оси X.",
            "2. Заполнить топливный бак заданным количеством бензина",
            "3. Вывести координату автомобиля",
            "4. Вывести уровень топлива в баке"
    };
    private static void printMessages(){
        for(String msg : messages){
            System.out.println(msg);
        }
    }
    public static void start(Car car, Scanner in){

        ConsoleFunction[] functions = {
                new ProgramQuit(),
                new MoveTo(car, in),
                new FillFuel(car, in),
                new ShowCoordinate(car),
                new ShowFuelLevel(car)
        };

        int returnCode = -1;
        do {
            printMessages();
            System.out.println();
            System.out.print("Выберите пункт меню (введите число от 0 до " + (messages.length - 1) + " включительно): ");
            int choice;
            try{
                choice = in.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Ошибка! Введено не число");
                in.next();
                continue;
            }
            if (choice < 0 || choice >= messages.length){
                System.out.println("Ошибка! Данного пункта меню не существует");
                continue;
            }
            returnCode = functions[choice].run();
        } while (returnCode != 0);


    }
}
