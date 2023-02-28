package javaAdvanced.DefiningClasses.Exercises.Google;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> personData = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] inputData = input.split("\\s+");
            String name = inputData[0];
            String command = inputData[1];
            Person currentPerson = null;
            if (!personData.containsKey(name)){
                currentPerson = new Person(name);
                personData.put(name, currentPerson);
            } else {
                currentPerson = personData.get(name);
            }
            switch (command){
                case "company" :
                    Company company =
                            new Company(inputData[2], inputData[3], Double.parseDouble(inputData[4]));
                    currentPerson.setCompany(company);
                    break;
                case "pokemon" :
                    Pokemon pokemon = new Pokemon(inputData[2], inputData[3]);
                    currentPerson.getPokemon().add(pokemon);
                    break;
                case "parents" :
                    Parent parent = new Parent(inputData[2], inputData[3]);
                    currentPerson.getParents().add(parent);
                    break;
                case "children" :
                    Children child = new Children(inputData[2], inputData[3]);
                    currentPerson.getChildren().add(child);
                    break;
                case "car" :
                    Car car = new Car(inputData[2], inputData[3]);
                    currentPerson.setCar(car);
                    break;
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        Person person = personData.get(input);
        System.out.println(person.toString());
    }
}
