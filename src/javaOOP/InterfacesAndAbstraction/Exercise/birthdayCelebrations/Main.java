package javaOOP.InterfacesAndAbstraction.Exercise.birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<Birthable> birthables = new ArrayList();
        List<Identifiable> robots = new ArrayList();
        while (!input[0].equals("End")) {
            String typeOfCharacter = input[0];
            String nameOrModel = input[1];
            int age;
            String id;
            String birthDay;
            switch (typeOfCharacter){
                case "Citizen" :
                    age = Integer.parseInt(input[2]);
                    id = input[3];
                    birthDay = input[4];
                    Citizen citizen = new Citizen(nameOrModel, age, id, birthDay);
                    birthables.add(citizen);
                    break;
                case "Pet" :
                    birthDay = input[2];
                    Pet pet = new Pet(nameOrModel, birthDay);
                    birthables.add(pet);
                    break;
                case "Robot" :
                    id = input[2];
                    Robot robot = new Robot(nameOrModel, id);
                    robots.add(robot);
                    break;
            }
            input = scanner.nextLine().split("\\s+");
        }
        String searchedBirthDayYear = scanner.nextLine();
        boolean noMatches = true;
        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(searchedBirthDayYear)) {
                System.out.println(birthable.getBirthDate());
                 noMatches = false;
            }
        }
        if (noMatches) {
            System.out.println("<no output>");
        }






        /*Class[] citizenInterfaces = Citizen.class.getInterfaces();
        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
            Method[] methods = Birthable.class.getDeclaredMethods();
            Method[] methods1 = Identifiable.class.getDeclaredMethods();
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String id = scanner.nextLine();
            String birthDate = scanner.nextLine();
            Identifiable identifiable = new Citizen(name,age,id,birthDate);
            Birthable birthable = new Citizen(name,age,id,birthDate);
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            System.out.println(methods1.length);
            System.out.println(methods1[0].getReturnType().getSimpleName());
        }*/
    }
}
