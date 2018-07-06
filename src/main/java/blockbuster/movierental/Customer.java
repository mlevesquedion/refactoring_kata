package blockbuster.movierental;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Enumeration;

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
            double thisAmount = 0;
            // determine amounts for each line
            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2)
                        thisAmount += (rental.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3)
                        thisAmount += (rental.getDaysRented() - 3) * 1.5;
                    break;
            }

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;

        }
        //add footer lines
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
