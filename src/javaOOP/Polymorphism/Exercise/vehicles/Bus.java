package javaOOP.Polymorphism.Exercise.vehicles;

public class Bus extends Vehicle{
    private static final double CONSUMPTION_INCREASE = 1.4;
    public Bus(double fuelQuantity, double fuelPerKm, double tankCapacity) {
        super(fuelQuantity, fuelPerKm + CONSUMPTION_INCREASE, tankCapacity);
    }
    @Override
    protected double getCurrentConsumption(boolean acON) {
        if (acON){
            return getFuelPerKm();
        }
        return getFuelPerKm() - CONSUMPTION_INCREASE;
    }

}
