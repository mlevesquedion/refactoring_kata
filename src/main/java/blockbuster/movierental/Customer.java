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

    public String getName() {
        return this.name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            double thisAmount = rental.cost();
            frequentRenterPoints += rental.frequentRenterPoints();

            result += rental.getLine();
            totalAmount += thisAmount;
        }
        result = addFooter(totalAmount, frequentRenterPoints, result);

        return result;
    }

    private String addFooter(double totalAmount, int frequentRenterPoints, String result) {
        result = addOwedAmount(totalAmount, result);
        result = addRenterPoints(frequentRenterPoints, result);
        return result;
    }

    private String addRenterPoints(int frequentRenterPoints, String result) {
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";
        return result;
    }

    private String addOwedAmount(double totalAmount, String result) {
        result += "You owed " + String.valueOf(totalAmount) + "\n";
        return result;
    }
}
