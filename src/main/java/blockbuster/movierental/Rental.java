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

    public Movie getMovie() {
        return this.movie;
    }

    public int frequentRenterPoints() {
        return 1 + (isEligibleForExtraPoints() ? 1 : 0);
    }

    private boolean isEligibleForExtraPoints() {
        return movie.eligibleForExtraPoints() && getDaysRented() > 1;
    }

    public double cost() {
        return movie.price(daysRented);
    }
}
