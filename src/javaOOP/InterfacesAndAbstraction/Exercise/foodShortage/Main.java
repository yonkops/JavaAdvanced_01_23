package javaOOP.InterfacesAndAbstraction.Exercise.foodShortage;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Buyer> persons = new TreeMap<>();
        int numberOfPersons = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfPersons; i++) {
            String[] person = scanner.nextLine().split("\\s+");
            String name = person[0];
            int age = Integer.parseInt(person[1]);
            if (person.length > 3) {
                String id = person[2];
                String birthDate = person[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                persons.put(name, citizen);
            } else {
                String group = person[2];
                Rebel rebel = new Rebel(name, age, group);
                persons.put(name, rebel);
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (persons.containsKey(input)){
                persons.get(input).buyFood();
            }
            input = scanner.nextLine();
        }
        System.out.println(persons.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
