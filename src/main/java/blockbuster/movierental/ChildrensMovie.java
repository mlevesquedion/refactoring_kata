package blockbuster.movierental;

public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title) {
        super(title);
    }

    @Override
    public boolean eligibleForExtraPoints() {
        return false;
    }

    @Override
    public double price(int daysRented) {
        return 1.5 + (daysRented > 3 ? (daysRented - 3) * 1.5 : 0.0);
    }
}
