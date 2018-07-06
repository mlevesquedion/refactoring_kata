package blockbuster.movierental;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class RentalHistoryTest {

    private RentalHistory rentalHistory;

    @Before
    public void setUp() throws Exception {
        List<Rental> rentals = Lists.newArrayList(
                RentalFixtures.of("STAR-WARS", MovieType.REGULAR, 2),
                RentalFixtures.of("CHICKEN LITTLE", MovieType.CHILDRENS, 5));
        rentalHistory = new RentalHistory(rentals);
    }

    @Test
    public void cost() {
        assertThat(rentalHistory.cost()).isWithin(1e-12).of(6.5);
    }

    @Test
    public void renterPoints() {
        assertThat(rentalHistory.renterPoints()).isEqualTo(2);
    }

    @Test
    public void lines() {
        assertThat(rentalHistory.lines()).isEqualTo("\tSTAR-WARS\t2.0\n\tCHICKEN LITTLE\t4.5\n");
    }
}