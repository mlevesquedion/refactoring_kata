package blockbuster.movierental;


import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class RentalTest {

    private static final Movie REGULAR = new Movie("MOVIE", Movie.REGULAR);
    private static final Rental ONE_DAY_REGULAR = new Rental(REGULAR, 1);
    private static final Movie NEW = new Movie("NEW", Movie.NEW_RELEASE);
    private static final Rental TWO_DAY_NEW = new Rental(NEW, 2);
    private static final Rental THREE_DAYS_REGULAR = new Rental(REGULAR, 3);
    private static final Rental ONE_DAY_NEW = new Rental(NEW, 1);
    private static final Movie CHILDRENS = new Movie("CHILDRENS", Movie.CHILDRENS);
    private static final Rental ONE_DAY_CHILDRENS = new Rental(CHILDRENS, 1);

    @Test
    public void givenAOneDayRegularMovie_shouldBeWorthOnePoint() {
        assertThat(ONE_DAY_REGULAR.frequentRenterPoints()).isEqualTo(1);
    }

    @Test
    public void givenATwoDayNewRelease_shouldBeWorthTwoPoints() {
        assertThat(TWO_DAY_NEW.frequentRenterPoints()).isEqualTo(2);
    }

    @Test
    public void oneDayRegularMovie_cost() {
        assertThat(ONE_DAY_REGULAR.cost()).isWithin(1e-12).of(2.0);
    }

    @Test
    public void threeDaysRegularMovie_cost() {
        assertThat(THREE_DAYS_REGULAR.cost()).isWithin(1e-12).of(3.5);
    }

    @Test
    public void oneDayNewRelease_cost() {
        assertThat(ONE_DAY_NEW.cost()).isWithin(1e-12).of(3.0);
    }

    @Test
    public void twoDaysNewRelease_cost() {
        assertThat(TWO_DAY_NEW.cost()).isWithin(1e-12).of(6.0);
    }

    @Test
    public void oneDayChildrens_cost() {
        assertThat(ONE_DAY_CHILDRENS.cost()).isWithin(1e-12).of(1.5);
    }
}