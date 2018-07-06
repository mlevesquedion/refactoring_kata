package blockbuster.movierental;

public class NewMovie extends Movie {
    public NewMovie(String title) {
        super(title, Movie.NEW_RELEASE);
    }

    @Override
    public boolean eligibleForExtraPoints() {
        return true;
    }

    @Override
    public double price(int daysRented) {
        return daysRented * 3.0;
    }
}