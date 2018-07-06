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
        double cost = movie.basePrice();
        if (movie.getPriceCode() == Movie.NEW_RELEASE) {
            cost += 3.0 * daysRented;
        }
        if (movie.getPriceCode() == Movie.CHILDRENS) {
            cost += daysRented > 3 ? (daysRented - 3) * 1.5 : 0;
        }
        if (movie.getPriceCode() == Movie.REGULAR) {
            cost += daysRented > 2 ? (daysRented - 2) * 1.5 : 0;
        }
        return cost;
    }
}
