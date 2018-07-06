package blockbuster.movierental;

public class RentalFixtures {

    public static Rental of(String movieTitle, MovieType movieType, int days) {
        return new Rental(MovieFactory.of(movieTitle, movieType), days);
    }

}
