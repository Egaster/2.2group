package lab2.Task9;

public class Car {
    private double coordinate;
    private double fuelLevel;
    private final double fuelConsumption;
    public Car(double fuelConsumption){
        this.fuelConsumption = fuelConsumption;
    }
    public void driveToKilometers(double kilometres){
        double maxAvailableDistance = fuelConsumption*fuelLevel;
        if (maxAvailableDistance < Math.abs(kilometres)){
            if (kilometres < 0){
                coordinate += (-1)*maxAvailableDistance;
            }
            else {
                coordinate += maxAvailableDistance;
            }
        }
        else {
            coordinate += kilometres;
        }

        fuelLevel = Math.max(0, fuelLevel - Math.abs(kilometres)/fuelConsumption);
    }
    public void fillFuel(double fuelAmount){
        if (fuelAmount < 0){
            System.out.println("Ошибка! Отрицательное число");
            return;
        }
        fuelLevel += fuelAmount;
    }
    public double getCoordinate(){
        return coordinate;
    }
    public double getFuelLevel(){
        return fuelLevel;
    }
}
