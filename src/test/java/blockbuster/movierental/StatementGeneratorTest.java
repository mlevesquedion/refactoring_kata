package blockbuster.movierental;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.BDDMockito.willReturn;

@RunWith(MockitoJUnitRunner.class)
public class StatementGeneratorTest {

    private static final Customer CUSTOMER = new Customer("MIKE");
    private static final Customer CUSTOMER_WITH_DIFFERENT_NAME = new Customer("JOHN");
    private StatementGenerator statementGenerator;

    @Mock
    private static Customer customer;

    @Before
    public void setUp() throws Exception {
        statementGenerator = new StatementGenerator();
        List<Rental> rentals = Lists.newArrayList(
                RentalFixtures.of("STAR-WARS", MovieType.REGULAR, 2),
                RentalFixtures.of("CHICKEN LITTLE", MovieType.CHILDRENS, 5));
        RentalHistory rentalHistory = new RentalHistory(rentals);
        willReturn(rentalHistory).given(customer).getRentals();
        willReturn("MIKE").given(customer).getName();
    }

    @Test
    public void givenACustomerWithNoRentals_shouldGenerateAMinimalStatement() {
        String actual = statementGenerator.generateStatement(CUSTOMER);
        String expected = "Rental Record for MIKE\nYou owed 0.0\nYou earned 0 frequent renter points\n";
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void generatedStatementShouldIncludeCustomersName() {
        String actual = statementGenerator.generateStatement(CUSTOMER_WITH_DIFFERENT_NAME);
        String expected = "Rental Record for JOHN\nYou owed 0.0\nYou earned 0 frequent renter points\n";
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void customerWithManyRentals() {
        String actual = statementGenerator.generateStatement(customer);
        String expected = "Rental Record for MIKE\n\tSTAR-WARS\t2.0\n\tCHICKEN LITTLE\t4.5\nYou owed 6.5\nYou earned 2 frequent renter points\n";
        assertThat(expected).isEqualTo(actual);
    }
}