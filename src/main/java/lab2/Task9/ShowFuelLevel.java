package lab2.Task9;

public class ShowFuelLevel implements ConsoleFunction{
    private Car car;
    public ShowFuelLevel(Car car){ this.car = car; }
    public int run(){
        System.out.println();
        System.out.println("Текущий уровень топлива: " + car.getFuelLevel());
        return 4;
    }
}
