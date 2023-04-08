package javaOOP.InterfacesAndAbstraction.Lab.borderControl;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Identifiable> borderCrosser = new ArrayList<>();
        String[] input = scanner.nextLine().split("\\s+");
        while (!input[0].equals("End")){
            if (input.length > 2){
                Citizen citizen = new Citizen(input[0], Integer.parseInt(input[1]), input[2]);
                borderCrosser.add(citizen);
            } else {
                Robot robot = new Robot(input[0], input[1]);
                borderCrosser.add(robot);
            }
            input = scanner.nextLine().split("\\s+");
        }
        String fakeId = scanner.nextLine();
       /* for (Identifiable crosser : borderCrosser){
            if (crosser.getId().endsWith(fakeId)){
                System.out.println(crosser.getId());
            }
        }*/
        borderCrosser.stream().filter(i -> i.getId().endsWith(fakeId))
                .forEach(identifiable -> System.out.println(identifiable.getId()));
    }
}
