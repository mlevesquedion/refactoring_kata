package blockbuster.movierental;

import java.util.List;

public class StatementGenerator {

    private String statement = "";

    public StatementGenerator() {
    }

    public String generateStatement(Customer customer) {
        List<Rental> rentals = customer.getRentals();
        return "Rental Record for " + customer.getName() + "\nYou owed 0.0\nYou earned 0 frequent renter points\n";
    }
}
