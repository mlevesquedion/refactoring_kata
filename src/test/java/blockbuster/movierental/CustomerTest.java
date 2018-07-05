package blockbuster.movierental;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class CustomerTest {

    private static final String NAME = "NAME";
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
}
