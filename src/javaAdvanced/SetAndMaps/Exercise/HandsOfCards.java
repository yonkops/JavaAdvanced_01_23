package javaAdvanced.SetAndMaps.Exercise;


import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> playersDecks = new LinkedHashMap<>();
        playersCards(scanner, input, playersDecks);
        calculateDeck(playersDecks);
    }

    private static void calculateDeck(Map<String, Set<String>> playersDecks) {
        for (Map.Entry<String, Set<String>> name : playersDecks.entrySet()) {
            int playerHand = 0;
            for (String card : playersDecks.get(name.getKey())) {
                String value = card.substring(0, card.length() - 1);
                String spade = card.substring(card.length() - 1);
                int x;
                switch (value){
                    case "J":
                        x = getSpades(spade);
                        playerHand += 11 * x;
                        break;
                    case "Q" :
                        x = getSpades(spade);
                        playerHand += 12 * x;
                        break;
                    case "K" :
                        x = getSpades(spade);
                        playerHand += 13 * x;
                        break;
                    case "A" :
                        x = getSpades(spade);
                        playerHand += 14 * x;
                        break;
                    default:
                        x = getSpades(spade);
                        playerHand += Integer.parseInt(value) * x;
                }
            }
            System.out.printf("%s: %d%n", name.getKey(), playerHand);
        }
    }

    private static int getSpades(String value) {
        int spadesPower = 1;
        switch (value) {
            case "S" :
                spadesPower = 4;
                break;
            case "H" :
                spadesPower = 3;
                break;
            case "D" :
                spadesPower = 2;
                break;
        };
        return spadesPower;
    }

    private static void playersCards(Scanner scanner, String input, Map<String, Set<String>> playersDecks) {
        String name;
        String[] cards;
        while (!input.equals("JOKER")){
            String[] splitInput = input.split(": ");
            name = splitInput[0];
            cards = splitInput[1].split(", ");
            Set<String> currentCards = new LinkedHashSet<>();
            Collections.addAll(currentCards, cards);
            if (playersDecks.containsKey(name)){
                playersDecks.get(name).addAll(currentCards);
            } else {
                playersDecks.put(name,currentCards);
            }
            input = scanner.nextLine();
        }
    }
}
