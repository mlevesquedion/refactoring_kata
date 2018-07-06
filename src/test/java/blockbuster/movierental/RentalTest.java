package blockbuster.movierental;


import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class RentalTest {

    private static final Movie REGULAR = new Movie("MOVIE", Movie.REGULAR);
    private static final Rental ONE_DAY_REGULAR = new Rental(REGULAR, 1);
    private static final Movie NEW = new Movie("NEW", Movie.NEW_RELEASE);
    private static final Rental TWO_DAY_NEW = new Rental(NEW, 2);

    @Test
    public void givenAOneDayRegularMovieRental_shouldBeWorthOnePoint() {
        assertThat(ONE_DAY_REGULAR.frequentRenterPoints()).isEqualTo(1);
    }

    @Test
    public void givenATwoDayNewRelease_shouldBeEligibleForExtraPoints() {
        assertThat(TWO_DAY_NEW.isEligibleForExtraPoints()).isTrue();
    }
}