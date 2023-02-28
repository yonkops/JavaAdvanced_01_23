package javaOOP.WorkingWithAbstraction.Lab.HotelReservation;

public class PriceCalculator {

    public static double calculateHolidayPrice(double pricePerDay, int days, Season season, DiscountType discountType) {
        double price = pricePerDay * days;
        price = price * season.getMultiplier();
        price = price - price * (discountType.getPercentage() / 100d);
        return price;
    }
}
