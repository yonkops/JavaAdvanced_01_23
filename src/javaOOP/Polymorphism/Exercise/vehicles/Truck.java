package javaOOP.Polymorphism.Exercise.vehicles;

public class Truck extends Vehicle {
    private static final double CONSUMPTION_INCREASE = 1.6;
    private static final double FUEL_LOSSES = 0.95;

    public Truck(double fuelQuantity, double fuelPerKm, double tankCapacity) {
        super(fuelQuantity, fuelPerKm + CONSUMPTION_INCREASE, tankCapacity);
    }
    @Override
    protected void refuel(double fuel) {
        super.refuel(fuel * FUEL_LOSSES);
    }
    @Override
    protected double getCurrentConsumption(boolean acON) {
        if (acON){
            return getFuelPerKm() + CONSUMPTION_INCREASE;
        }
        return getFuelPerKm();
    }
}
