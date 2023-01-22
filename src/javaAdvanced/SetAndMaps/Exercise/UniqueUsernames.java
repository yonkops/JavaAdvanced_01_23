package javaAdvanced.SetAndMaps.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nInputs = Integer.parseInt(scanner.nextLine());
        Set<String> users = new LinkedHashSet<>();
        for (int i = 0; i < nInputs; i++) {
            String username = scanner.nextLine();
            users.add(username);
        }
        users.forEach(System.out::println);
    }
}
