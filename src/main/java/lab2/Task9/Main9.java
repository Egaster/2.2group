package lab2.Task9;

public class Main9 {
    public static void main(String[] args) {
        Car car = new Car(30);
        car.fillFuel(20);
        car.driveToKilometers(60);
        System.out.println("Distance passed: " + car.getDistance());
        System.out.println("Fuel level: "+ car.getFuelLevel());
        car.driveToKilometers(30);
        System.out.println("Distance passed: " + car.getDistance());
        System.out.println("Fuel level: "+ car.getFuelLevel());
    }
}