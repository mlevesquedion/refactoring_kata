package blockbuster.movierental;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return this.daysRented;
    }

    public int frequentRenterPoints() {
        return 1 + (isEligibleForExtraPoints() ? 1 : 0);
    }

    private boolean isEligibleForExtraPoints() {
        return movie.eligibleForExtraPoints() && getDaysRented() > 1;
    }

    public double cost() {
        return movie.priceFor(daysRented);
    }

    public String getLine() {
        return "\t" + movie.getTitle() + "\t" + String.valueOf(cost()) + "\n";
    }
}
