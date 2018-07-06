package blockbuster.movierental;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class CustomerTest {

    private static final String NAME = "NAME";
    private static final Movie REGULAR_MOVIE = new Movie("MOVIE", Movie.REGULAR);
    private static final Rental REGULAR_ONE_DAY = new Rental(REGULAR_MOVIE, 1);
    private static final Rental REGULAR_THREE_DAYS = new Rental(REGULAR_MOVIE, 3);
    private static final Movie NEW_RELEASE_MOVIE = new Movie("NEW", Movie.NEW_RELEASE);
    private static final Rental NEW_RELEASE_ONE_DAY = new Rental(NEW_RELEASE_MOVIE, 1);
    private static final Rental NEW_RELEASE_TWO_DAYS = new Rental(NEW_RELEASE_MOVIE, 2);
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer(NAME);
    }

    @Test
    public void customerWithNoRentals() throws Exception {
        String expected = getStatement("", "0.0", "0");
        assertThat(customer.statement()).isEqualTo(expected);
    }

    @Test
    public void customerWithRegularOneDayRental() {
        customer.addRental(REGULAR_ONE_DAY);
        String expected = getStatement("\tMOVIE\t2.0\n","2.0", "1");
        assertThat(customer.statement()).isEqualTo(expected);
    }

    @Test
    public void customerWithRegularThreeDaysRental() {
        customer.addRental(REGULAR_THREE_DAYS);
        String expected = getStatement("\tMOVIE\t3.5\n", "3.5", "1");
        assertThat(customer.statement()).isEqualTo(expected);
    }

    @Test
    public void customerWithNewReleaseOneDayRental() {
        customer.addRental(NEW_RELEASE_ONE_DAY);
        String expected = getStatement("\tNEW\t3.0\n", "3.0", "1");
        assertThat(customer.statement()).isEqualTo(expected);
    }

    @Test
    public void customerWithNewReleaseTwoDaysRental() {
        customer.addRental(NEW_RELEASE_TWO_DAYS);
        String expected = getStatement("\tNEW\t6.0\n", "6.0", "2");
        assertThat(customer.statement()).isEqualTo(expected);
    }

    private String getStatement(String formattedRentals, String amount, String renterPoints) {
        return String.format("Rental Record for NAME\n%sYou owed %s\nYou earned %s frequent renter points\n", formattedRentals, amount, renterPoints);
    }

}
