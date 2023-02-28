package javaOOP.WorkingWithAbstraction.Exercise.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("Card Ranks:");
        for (CardRanks cardRank : CardRanks.values()){
            System.out.println(cardRank.toString());
        }*/
        Scanner scanner = new Scanner(System.in);
        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();
        Card card = new Card(cardRank, cardSuit);
        System.out.println(card.toString());
    }
}
