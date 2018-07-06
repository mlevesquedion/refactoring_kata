package blockbuster.movierental;

public class MovieFactory {

    public static Movie of(String title, MovieType movieType) {
        switch (movieType) {
            case REGULAR:
                return new RegularMovie(title);
            case CHILDRENS:
                return new ChildrensMovie(title);
            case NEW:
                // fall-through
            default:
                return new NewMovie(title);
        }
    }

}
