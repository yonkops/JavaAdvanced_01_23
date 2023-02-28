package javaAdvanced.DefiningClasses.Exercises.RawData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Car>> carsByCargoType = new HashMap<>();
//          input
//        ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4
//        Citroen2CV 190 165 1200 fragile 0.9 3 0.85 2 0.95 2 1.1 1
//            0         1               2           3              4
//        "{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType}" +
//                  5           6           7               8
//        " {Tire1Pressure} {Tire1Age} {Tire2Pressure} {Tire2Age}" +
//                  9           10              11          12
//        " {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}"
        int carForCargo = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < carForCargo; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String carModelInput = input[0];
            int enginePowerInput = Integer.parseInt(input[2]);
            String cargoInput = input[4];
            Engine engine = new Engine(enginePowerInput);
            Cargo cargo = new Cargo(cargoInput);
            List<Tire> tireList = new ArrayList<>();
            for (int j = 5; j < 13; j += 2) {
                Tire currentTire = new Tire(Double.parseDouble(input[j]));
                tireList.add(currentTire);
            }
            Car currentCar = new Car(carModelInput, engine, cargo, tireList);
            carsByCargoType.putIfAbsent(cargoInput, new ArrayList<>());
            carsByCargoType.get(cargoInput).add(currentCar);
        }
        String command = scanner.nextLine();
        carsByCargoType.get(command).forEach(car -> car.extract(command));
    }
}
