package blockbuster.movierental;

public abstract class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public abstract boolean eligibleForExtraPoints();

    public abstract double price(int daysRented);
}
