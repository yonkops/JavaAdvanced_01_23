package javaAdvanced.SetAndMaps.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        int count = 0;

        while (count != 50){
            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            } else {
                int p1Card = firstDeck.iterator().next();
                int p2Card = secondDeck.iterator().next();
                firstDeck.remove(p1Card);
                secondDeck.remove(p2Card);
                if (p1Card > p2Card) {
                    firstDeck.add(p1Card);
                    firstDeck.add(p2Card);
                } else if (p1Card < p2Card) {
                    secondDeck.add(p1Card);
                    secondDeck.add(p2Card);
                }
            }
            count++;
        }
        if (firstDeck.size() > secondDeck.size()){
            System.out.println("First player win!");
        } else if (firstDeck.size() < secondDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }

    }
}
