package blockbuster.movierental;

public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean eligibleForExtraPoints() {
        return priceCode == Movie.NEW_RELEASE;
    }

    private double basePrice() {
        switch(priceCode) {
            case REGULAR:
                return 2.0;
            case CHILDRENS:
                return 1.5;
            case NEW_RELEASE:
                // fall-through
            default:
                return 0;
        }
    }

    private double priceFor(int daysRented) {
        switch (priceCode) {
            case REGULAR:
                return daysRented > 2 ? (daysRented - 2) * 1.5 : 0.0;
            case NEW_RELEASE:
                return daysRented * 3.0;
            case CHILDRENS:
                return daysRented > 3 ? (daysRented - 3) * 1.5 : 0.0;
            default:
                return 0.0;
        }
    }

    public double price(int daysRented) {
        return basePrice() + priceFor(daysRented);
    }
}
