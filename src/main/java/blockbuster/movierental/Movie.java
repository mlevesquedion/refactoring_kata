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

    public int getPriceCode() {
        return this.priceCode;
    }

    public void setPriceCode(int code) {
        this.priceCode = code;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean eligibleForExtraPoints() {
        return priceCode == Movie.NEW_RELEASE;
    }

    public double basePrice() {
        return 2.0;
    }
}
