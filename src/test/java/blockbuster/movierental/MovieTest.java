package blockbuster.movierental;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class MovieTest {

    private static final Movie REGULAR = new Movie("REGULAR", Movie.REGULAR);
    private static final Movie CHILDRENS = new Movie("CHILDRENS", Movie.CHILDRENS);
    private static final Movie NEW = new Movie("NEW", Movie.NEW_RELEASE);

    @Test
    public void regularMovie_points() {
        assertThat(REGULAR.eligibleForExtraPoints()).isFalse();
    }

    @Test
    public void childrensMovie_points() {
        assertThat(CHILDRENS.eligibleForExtraPoints()).isFalse();
    }

    @Test
    public void newMovie_points() {
        assertThat(NEW.eligibleForExtraPoints()).isTrue();
    }
}