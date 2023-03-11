package lab2.Task9;

public class Car {
    private double distance;
    private double fuelLevel;
    private final double fuelConsumption;
    public Car(double fuelConsumption){
        this.fuelConsumption = fuelConsumption;
    }
    public void driveToKilometers(double kilometres){
        distance += Math.min(kilometres, fuelLevel*fuelConsumption);
        fuelLevel = Math.max(0, fuelLevel - kilometres/fuelConsumption);
    }
    public void fillFuel(double fuelAmount){
        fuelLevel += fuelAmount;
    }
    public double getDistance(){
        return distance;
    }
    public double getFuelLevel(){
        return fuelLevel;
    }
}
