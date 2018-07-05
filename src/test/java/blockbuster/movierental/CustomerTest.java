package blockbuster.movierental;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        ArrayList<Rental> rentals = Lists.newArrayList(REGULAR_ONE_DAY);
        String expected = getStatement("\tMOVIE\t2.0",2, 1);
        assertThat(customer.statement()).isEqualTo(expected);
    }

    private String getStatement(String formattedRentals, double amount, int renterPoints) {
        return String.format("Rental Record for NAME\n%s\nYou owed %.1f\nYou earned %d frequent renter points\n", formattedRentals, amount, renterPoints);
    }

}
