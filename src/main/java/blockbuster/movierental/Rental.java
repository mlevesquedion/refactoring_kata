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
        return 1;
    }

    public boolean isEligibleForExtraPoints() {
        return movie.getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1;
    }
}
