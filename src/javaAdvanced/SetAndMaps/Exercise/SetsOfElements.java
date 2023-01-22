package javaAdvanced.SetAndMaps.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int sizeOfFirst = Integer.parseInt(input.split("\\s+")[0]);
        int sizeOfSecond = Integer.parseInt(input.split("\\s+")[1]);
        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();
        fillSet(sizeOfFirst, scanner, first);
        fillSet(sizeOfSecond, scanner, second);
        // Remove all not duplicated elements
        first.retainAll(second);
        first.forEach(el -> System.out.print(el + " "));
    }

    private static void fillSet(int sizeOfFirst, Scanner scanner, Set<Integer> first) {
        String input;
        for (int i = 0; i < sizeOfFirst; i++) {
            input = scanner.nextLine();
            first.add(Integer.parseInt(input));
        }
    }
}
