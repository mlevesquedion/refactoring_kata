package blockbuster.movierental;

import java.util.List;

public class StatementGenerator {

    private String statement = "";

    public StatementGenerator() {
    }

    public String generateStatement(Customer customer) {
        statement += "Rental Record for " + customer.getName() + "\n";
        List<Rental> rentals = customer.getRentals();
        int frequentRenterPoints = rentals.stream().mapToInt(Rental::frequentRenterPoints).sum();
        double cost = rentals.stream().map(Rental::cost).reduce(0.0, Double::sum);
        for (Rental rental : rentals) {
            statement += rental.getLine();
        }
        statement += "You owed " + String.valueOf(cost) + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";
        return statement;
    }
}
