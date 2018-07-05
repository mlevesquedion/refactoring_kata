package blockbuster.movierental;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class CustomerTest {

    private static final String NAME = "NAME";
    private static final Movie REGULAR_MOVIE = new Movie("MOVIE", Movie.REGULAR);
    private static final Rental REGULAR_ONE_DAY = new Rental(REGULAR_MOVIE, 1);
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer(NAME);
    }

    @Test
    public void givenCustomerWithNoRentals_shouldProduceMinimalStatement() throws Exception {
        String expected = "Rental Record for NAME\nYou owed 0.0\nYou earned 0 frequent renter points\n";
        assertThat(customer.statement()).isEqualTo(expected);
    }

    @Test
    public void customerWithRegularOneDayRental() {
        customer.addRental(REGULAR_ONE_DAY);
        String expected = getStatement();
        assertThat(customer.statement()).isEqualTo(expected);
    }

    private String getStatement() {
        return "Rental Record for NAME\n\tMOVIE\t2.0\nYou owed 2.0\nYou earned 1 frequent renter points\n";
    }


}
