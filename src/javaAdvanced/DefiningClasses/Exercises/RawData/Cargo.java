package javaAdvanced.DefiningClasses.Exercises.RawData;


import java.util.List;


public class Cargo {
    private String cargoType;
    private int cargoWeight;
    private Car car;

    public Cargo(String cargoType, int weight, Car car) {
        this.cargoType = cargoType;
        this.cargoWeight = weight;
        this.car = car;
    }

    public Cargo(String cargoType) {
        this.cargoType = cargoType;
    }
}
