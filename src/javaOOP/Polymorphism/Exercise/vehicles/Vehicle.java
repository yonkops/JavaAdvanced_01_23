package javaOOP.Polymorphism.Exercise.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    final DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private double fuelQuantity;
    private final double fuelPerKm;
    private final double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelPerKm = fuelPerKm;
        this.tankCapacity = tankCapacity;
    }
    protected void drive(double distance, String vehicle, boolean acOn){
        double currentFuelPerKM = getCurrentConsumption(acOn);
        double neededFuel = distance * (currentFuelPerKM);
        if (fuelQuantity >= neededFuel){
            fuelQuantity -= neededFuel;
            System.out.printf("%s travelled %s km%n",
                    vehicle, (decimalFormat.format(distance)));
        } else {
            System.out.printf("%s needs refueling%n", vehicle);
        }

    }
    protected void refuel(double fuel){
        if (fuel < 1) {
            System.out.println("Fuel must be a positive number");
        } else if (tankCapacity < fuelQuantity + fuel) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            setFuelQuantity(fuel + getFuelQuantity());
        }
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelPerKm(){
        return this.fuelPerKm;
    }
    protected abstract double getCurrentConsumption(boolean acOn);
}
