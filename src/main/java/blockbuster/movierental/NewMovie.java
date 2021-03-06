package blockbuster.movierental;

public class NewMovie extends Movie {
    public NewMovie(String title) {
        super(title);
    }

    @Override
    public boolean eligibleForExtraPoints() {
        return true;
    }

    @Override
    public double priceFor(int daysRented) {
        return daysRented * 3.0;
    }
}
