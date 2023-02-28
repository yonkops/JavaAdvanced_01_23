package javaOOP.WorkingWithAbstraction.Lab.HotelReservation;

public enum DiscountType {
    VIP("VIP", 20),
    SECONDVISIT("SecondVisit", 10),
    NONE("None", 0);

    private String discountType;
    private int percentage;

    DiscountType(String discountType, int percentage) {
        this.discountType = discountType;
        this.percentage = percentage;
    }

    public String getDiscountType() {
        return discountType;
    }

    public int getPercentage() {
        return percentage;
    }
}
