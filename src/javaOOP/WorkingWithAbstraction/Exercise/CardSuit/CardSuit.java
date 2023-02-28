package javaOOP.WorkingWithAbstraction.Exercise.CardSuit;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int value;

    CardSuit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Ordinal value: %d; Name value: %s",
                this.value, this.name());
    }
}
