package blockbuster.movierental;

import java.util.ArrayList;
import java.util.List;

public class RentalHistory {

    List<Rental> rentals;

    public RentalHistory() {
        this.rentals = new ArrayList();
    }

    public RentalHistory(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public void add(Rental rental) {
        rentals.add(rental);
    }

    public double cost() {
        return rentals.stream().map(Rental::cost).reduce(0.0, Double::sum);
    }

    public int renterPoints() {
        return rentals.stream().mapToInt(Rental::frequentRenterPoints).sum();
    }

    public String lines() {
        String lines = "";
        for (Rental rental : rentals) {
            lines += rental.getLine();
        }
        return lines;
    }
}
