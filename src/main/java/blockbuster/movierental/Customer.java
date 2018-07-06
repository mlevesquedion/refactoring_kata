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
            double thisAmount = calculateCost(rental);
            frequentRenterPoints = addRenterPoints(frequentRenterPoints, rental);


            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;

        }
        result = addFooter(totalAmount, frequentRenterPoints, result);

        return result;
    }

    private int addRenterPoints(int frequentRenterPoints, Rental rental) {
        frequentRenterPoints++;
        if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    private double calculateCost(Rental rental) {
        double amount = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (rental.getDaysRented() > 2)
                    amount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                amount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                amount += 1.5;
                if (rental.getDaysRented() > 3)
                    amount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return amount;
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
