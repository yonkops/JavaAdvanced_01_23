package javaAdvanced.DefiningClasses.Exercises.RawData;

public class Tire {
    private double tirePressure;
    private int tireAge;

    public Tire(double tirePressure, int tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    public Tire(double tirePressure) {
        this.tirePressure = tirePressure;
    }

    public double getTirePressure() {
        return tirePressure;
    }
}
