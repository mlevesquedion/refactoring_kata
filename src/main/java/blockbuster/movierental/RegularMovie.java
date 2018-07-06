package blockbuster.movierental;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public boolean eligibleForExtraPoints() {
        return false;
    }

    @Override
    public double priceFor(int daysRented) {
        return 2.0 + (daysRented > 2 ? (daysRented - 2) * 1.5 : 0.0);
    }
}
