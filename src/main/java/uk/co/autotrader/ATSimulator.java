package uk.co.autotrader;

import java.util.ArrayList;
import java.util.List;

public class ATSimulator {

    private final ArrayList<String> output = new ArrayList<>();

    public List<String> outputSimulation() {
        runSimulation();

        for (String line: output) {
            System.out.println(line);
        }

        return output;
    }

    private void runSimulation() {
        output.add("**********************");
        output.add("Welcome to Mini Autotrader!");

        Autotrader at = new Autotrader(output);

        Retailer bobsBelles = new Retailer("Bob's and Belle's Bangers");
        Retailer bigBucks = new Retailer("Big Buck’s Best Deals");
        Retailer olGranny = new Retailer("Ol’ Granny Guardrails");

        Customer customer1 = new Customer("Megan Moneybanks");
        Customer customer2 = new Customer("Robin Banks");
        Customer customer3 = new Customer("Steve McSteve");

        Listing listing1 = new Listing("1999 Ford Fiesta",bobsBelles);
        at.addListing(listing1);

        Listing listing2 = new Listing("Tesla Model Y",bigBucks);
        at.addListing(listing2);

        Listing listing3 = new Listing("Fire Truck",bigBucks);
        at.addListing(listing3);

        Listing listing4 = new Listing("Robin Reliant",olGranny);
        at.addListing(listing4);
        at.browseCars();

        output.add("**********************");

        output.add("CAR PURCHASES:");
        at.sellCar(listing1,customer1);
        at.sellCar(listing2,customer2);
        at.sellCar(listing3,customer3);

        output.add("**********************");
        at.countListings();
        at.browseCars();

    }
}
