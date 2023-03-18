package lab2.Task9;

import java.util.Scanner;

public class ShowCoordinate implements ConsoleFunction{
    private Car car;
    public ShowCoordinate(Car car){ this.car = car; }
    public int run(){
        System.out.println();
        System.out.println("Текущая координата: " + car.getCoordinate());
        return 3;
    }
}
