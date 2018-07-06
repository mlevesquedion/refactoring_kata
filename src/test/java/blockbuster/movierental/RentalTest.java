package blockbuster.movierental;


import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class RentalTest {

    private static final Movie REGULAR = new RegularMovie("MOVIE");
    private static final Rental ONE_DAY_REGULAR = new Rental(REGULAR, 1);
    private static final Rental FOUR_DAYS_REGULAR = new Rental(REGULAR, 4);
    private static final Movie NEW = new NewMovie("NEW");
    private static final Rental ONE_DAY_NEW = new Rental(NEW, 1);
    private static final Rental TWO_DAY_NEW = new Rental(NEW, 2);
    private static final Movie CHILDRENS = new ChildrensMovie("CHILDRENS");
    private static final Rental ONE_DAY_CHILDRENS = new Rental(CHILDRENS, 1);
    private static final Rental FIVE_DAYS_CHILDRENS = new Rental(CHILDRENS, 5);

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
    public void fourDaysRegularMovie_cost() {
        assertThat(FOUR_DAYS_REGULAR.cost()).isWithin(1e-12).of(5.0);
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

    @Test
    public void fiveDayChildrens_cost() {
        assertThat(FIVE_DAYS_CHILDRENS.cost()).isWithin(1e-12).of(4.5);
    }
}