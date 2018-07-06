package blockbuster.movierental;

public class RegularMovie extends Movie {

    public RegularMovie(String title) {
        super(title, Movie.REGULAR);
    }

    @Override
    public double price(int daysRented) {
        return 2.0 + (daysRented > 2 ? (daysRented - 2) * 1.5 : 0.0);
    }

}
