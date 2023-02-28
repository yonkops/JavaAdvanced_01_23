package javaOOP.WorkingWithAbstraction.Exercise.CardSuit;

public enum CardRanks {
    ACE(14), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    private int rank;

    CardRanks(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.format("Ordinal value: %d; Name value: %s",
                this.rank, this.name());
    }
}
