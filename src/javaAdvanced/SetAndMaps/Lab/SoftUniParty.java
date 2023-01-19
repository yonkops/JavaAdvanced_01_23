package javaAdvanced.SetAndMaps.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> partiMembers = new TreeSet<>();
        String input = scanner.nextLine();
        while (!input.equals("PARTY")){
            partiMembers.add(input);
            input = scanner.nextLine();
        }
        while (!input.equals("END")){
            partiMembers.remove(input);
            input = scanner.nextLine();
        }
        System.out.println(partiMembers.size());
        for (String member : partiMembers
        ) {
            System.out.println(member);
        }
    }
}
