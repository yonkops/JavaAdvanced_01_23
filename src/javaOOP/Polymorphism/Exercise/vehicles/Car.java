package javaOOP.Polymorphism.Exercise.vehicles;

public class Car extends Vehicle {
    private static final double CONSUMPTION_INCREASE = 0.9;

    public Car(double fuelQuantity, double fuelPerKm, double tankCapacity) {
        super(fuelQuantity, fuelPerKm + CONSUMPTION_INCREASE, tankCapacity);
    }
    @Override
    protected double getCurrentConsumption(boolean acON) {
        if (acON){
            return getFuelPerKm() + CONSUMPTION_INCREASE;
        }
        return getFuelPerKm();
    }


}
