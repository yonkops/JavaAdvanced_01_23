package javaAdvanced.DefiningClasses.Exercises.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Engine> engines = new ArrayList<>();
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String [] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int power = Integer.parseInt(data[1]);
            int displacement = 0;
            String efficiency = null;
            if (data.length == 4){
                displacement = Integer.parseInt(data[2]);
                efficiency = data[3];
            } else if (data.length == 3){
                if (Character.isDigit(data[2].charAt(0))){
                    displacement = Integer.parseInt(data[2]);
                } else {
                    efficiency = data[2];
                }
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }
        count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[]data = scanner.nextLine().split("\\s+");
            String carModel = data[0];
            String engineModel = data[1];
            int weight = 0;
            String color = null;
            if (data.length == 4){
                weight = Integer.parseInt(data[2]);
                color = data[3];
            } else if (data.length == 3){
                if (Character.isDigit(data[2].charAt(0))){
                    weight = Integer.parseInt(data[2]);
                } else {
                    color = data[2];
                }
            }
            Engine carEngine = null;
            for (Engine engine : engines){
                if (engineModel.equals(engine.getModel())){
                    carEngine = engine;
                    break;
                }
            }
            Car car = new Car(carModel, carEngine, weight, color);
            System.out.print(car.toString());
        }
    }
}
