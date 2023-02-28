package javaOOP.WorkingWithAbstraction.Lab.HotelReservation;

public enum Season {
    SUMMER("Summer", 4),
    AUTUMN("Autumn", 1),
    WINTER("Winter", 3),
    SPRING("Spring", 2);

    private String name;
    private int multiplier;

    Season(String name, int multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}