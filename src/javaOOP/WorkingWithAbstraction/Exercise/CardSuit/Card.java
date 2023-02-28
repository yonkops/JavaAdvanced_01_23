package javaOOP.WorkingWithAbstraction.Exercise.CardSuit;

public class Card {
    String cardSuite;
    String cardRank;

    public Card(String cardRank, String cardSuite) {
        this.cardSuite = cardSuite;
        this.cardRank = cardRank;
    }

    public int getPower() {
        int suit = CardSuit.valueOf(this.cardSuite).getValue();
        int rank = CardRanks.valueOf(this.cardRank).getRank();
        return rank + suit;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                CardRanks.valueOf(this.cardRank).name(),
                CardSuit.valueOf(this.cardSuite).name(),
                getPower());
    }
}
