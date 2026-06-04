package uk.co.autotrader;

import java.util.ArrayList;
import java.util.List;

public class ATSimulator {

    private final ArrayList<String> output = new ArrayList<>();
    Autotrader at = new Autotrader(output);

    public List<String> outputSimulation(int day) {
        switch (day) {
            case 1: runSimulationDay1();
            break;
            case 2: runSimulationDay2();
            break;
            case 3: runSimulationDay3();
            break;
            case 4: summary();
            break;
        }

        for (String line: output) {
            System.out.println(line);
        }

        return output;
    }

    private void runSimulationDay1() {
        output.add("********************** Day 1");
        output.add("Welcome to Mini Autotrader!");

        at.addRetailer(new Retailer("Bob's and Belle's Bangers"));
        at.addRetailer(new Retailer("Big Buck's Best Deals"));
        at.addRetailer(new Retailer("Ol' Granny Guardrails"));

        at.addCustomer(new Customer("Megan Moneybanks"));
        at.addCustomer(new Customer("Robin Banks"));
        at.addCustomer(new Customer("Steve McSteve"));


        Listing listing1 = new Listing("1999 Ford Fiesta",at.findRetailerByName("Bob's and Belle's Bangers"));
        at.addListing(listing1);

        Listing listing2 = new Listing("Tesla Model Y",at.findRetailerByName("Big Buck's Best Deals"));
        at.addListing(listing2);

        Listing listing3 = new Listing("Fire Truck",at.findRetailerByName("Big Buck's Best Deals"));
        at.addListing(listing3);

        Listing listing4 = new Listing("Robin Reliant",at.findRetailerByName("Ol' Granny Guardrails"));
        at.addListing(listing4);

        at.browseCars();

        output.add("**********************");

        output.add("CAR PURCHASES:");
        at.sellCar(listing1,at.findCustomerByName("Megan Moneybanks"));
        at.sellCar(listing2,at.findCustomerByName("Robin Banks"));
        at.sellCar(listing3,at.findCustomerByName("Steve McSteve"));

        output.add("**********************");
        int count = at.countListings();
        output.add("There are " + count + " cars listed on Autotrader.");
        at.browseCars();
    }

    private void runSimulationDay2() {
        output.add("********************** Day 2");
        output.add("Welcome to Mini Autotrader!");

        at.retailers.add(new Retailer("Eman's hot wheels"));
        at.retailers.add(new Retailer("Another retailer"));

        at.customers.add(new Customer("Penny Coin"));
        at.customers.add(new Customer("Johny Bravo"));

        Listing listing1 = new Listing("Fiat 500",at.findRetailerByName("Eman's hot wheels"));
        at.addListing(listing1);
        Listing listing2 = new Listing("Unknown car",at.findRetailerByName("Another retailer"));
        at.addListing(listing2);
        at.browseCars();

        output.add("**********************");
        output.add("CAR PURCHASES:");
        at.sellCar(at.findListingByName("Robin Reliant"),at.findCustomerByName("Penny Coin"));

        output.add("**********************");
        int count = at.countListings();
        output.add("There are " + count + " cars listed on Autotrader.");
        at.browseCars();
    }

    private void runSimulationDay3() {
        output.add("********************** Day 3");
        output.add("Welcome to Mini Autotrader!");

        at.retailers.add(new Retailer("Last retailer"));
        at.customers.add(new Customer("Peter Pan"));

        Listing listing1 = new Listing("Bus",at.findRetailerByName("Last retailer"));
        at.addListing(listing1);

        output.add("**********************");
        output.add("CAR PURCHASES:");
        output.add("**********************");
        int count = at.countListings();
        output.add("There are " + count + " cars listed on Autotrader.");
        at.browseCars();
    }

    public void summary() {
        output.add("**********************");
        output.add("Performance for last 3 days");
        output.add("Total sold cars: " + at.boughtCars.size());
        at.browseCars();
    }

}
