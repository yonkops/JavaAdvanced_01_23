package javaAdvanced.DefiningClasses.Exercises.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distanceTraveled;

    public Car(String model, int fuelAmount, double priceFuelPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = priceFuelPerKm;
        distanceTraveled = 0;
    }

    public boolean drive(int kmDrive){
        double needFuel = kmDrive * this.fuelCostPerKm;
        if (needFuel <= this.fuelAmount){
            this.fuelAmount -= needFuel;
            this.distanceTraveled += kmDrive;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }

}
