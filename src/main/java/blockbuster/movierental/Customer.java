package blockbuster.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public String getName() {
        return this.name;
    }

    public String statement() {
        return new StatementGenerator().generateStatement(this);
    }
}
