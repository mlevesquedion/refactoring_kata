package blockbuster.movierental;

import java.util.List;

public class StatementGenerator {

    private Customer customer;
    private List<Rental> rentals;
    private String statement = "";

    public StatementGenerator(Customer customer, List<Rental> rentals) {
        this.customer = customer;
        this.rentals = rentals;
    }
}
