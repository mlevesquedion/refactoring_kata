package blockbuster.movierental;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class MovieTest {

    private static final Movie REGULAR = new RegularMovie("REGULAR");
    private static final Movie CHILDRENS = new ChildrensMovie("CHILDRENS");
    private static final Movie NEW = new NewMovie("NEW");

    @Test
    public void givenRegularMovie_shouldNotBeEligibleForExtraPoints() {
        assertThat(REGULAR.eligibleForExtraPoints()).isFalse();
    }

    @Test
    public void givenChildrensMovie_shouldNotBeEligibleForExtraPoints() {
        assertThat(CHILDRENS.eligibleForExtraPoints()).isFalse();
    }

    @Test
    public void givenNewMovie_shouldBeEligibleForExtraPoints() {
        assertThat(NEW.eligibleForExtraPoints()).isTrue();
    }

    @Test
    public void regularMovieTwoDays_price() {
        assertThat(REGULAR.priceFor(2)).isWithin(1e-12).of(2.0);
    }

    @Test
    public void childrensMovieThreeDays_price() {
        assertThat(CHILDRENS.priceFor(3)).isWithin(1e-12).of(1.5);
    }

    @Test
    public void newMovieOneDay_price() {
        assertThat(NEW.priceFor(1)).isWithin(1e-12).of(3.0);
    }

    @Test
    public void regularMovieFiveDays_price() {
        assertThat(REGULAR.priceFor(5)).isWithin(1e-12).of(6.5);
    }

    @Test
    public void newMovieTwoDays_price() {
        assertThat(NEW.priceFor(2)).isWithin(1e-12).of(6.0);
    }

    @Test
    public void childrensMovieSixDays_price() {
        assertThat(CHILDRENS.priceFor(6)).isWithin(1e-12).of(6.0);
    }
}