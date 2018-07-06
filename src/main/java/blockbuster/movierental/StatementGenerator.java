package blockbuster.movierental;

public class StatementGenerator {

    private String statement = "";

    public StatementGenerator() {
    }

    public String generateStatement(Customer customer) {
        statement += "Rental Record for " + customer.getName() + "\n";
        RentalHistory rentals = customer.getRentals();
        int frequentRenterPoints = rentals.renterPoints();
        double cost = rentals.cost();
        statement += rentals.lines();
        statement += "You owed " + String.valueOf(cost) + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";
        return statement;
    }
}
