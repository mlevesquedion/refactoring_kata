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
        if (movie.getPriceCode() == Movie.NEW_RELEASE) {
            return 3.0 * daysRented;
        }
        if (movie.getPriceCode() == Movie.CHILDRENS) {
            return 1.5 + (daysRented > 3 ? (daysRented - 3) * 1.5 : 0);
        }
        return movie.basePrice() + (daysRented > 2 ? (daysRented - 2) * 1.5 : 0);
    }
}
