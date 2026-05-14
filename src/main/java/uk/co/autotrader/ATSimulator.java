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
        output.add("Welcome to Mini Autotrader!");
        Autotrader at = new Autotrader();
        Retailer bobsBelles = new Retailer("Bob's and Belle's Bangers");
        Retailer bigBucks = new Retailer("Big Buck’s Best Deals");
        Retailer olGranny = new Retailer("Ol’ Granny Guardrails");

        Customer customer1 = new Customer("Megan MoneyBanks");
        Customer customer2 = new Customer("Robin Banks");
        Customer customer3 = new Customer("Steve McSteve");

        Listing listing1 = new Listing("1999 Ford Fiesta",bobsBelles);
        at.addListing(listing1);
        output.add(bobsBelles.getRetailerName() + " has listed a " + listing1.vehicle + " on Autotrader.");

        Listing listing2 = new Listing("Tesla Model Y",bigBucks);
        at.addListing(listing2);
        output.add(bigBucks.getRetailerName() + " has listed a " + listing2.vehicle + " on Autotrader.");

        Listing listing3 = new Listing("Fire Truck",bigBucks);
        at.addListing(listing3);
        output.add(bigBucks.getRetailerName() + " has listed a " + listing3.vehicle + " on Autotrader.");

        Listing listing4 = new Listing("Robin Reliant",olGranny);
        at.addListing(listing4);
        output.add(olGranny.getRetailerName() + " has listed a " + listing4.vehicle + " on Autotrader.");


        output.add("number" + at.countListings());
        output.add("Car purchases:");
        output.add(at.sellCar(listing1,customer1));
        output.add(at.sellCar(listing2,customer2));
        output.add(at.sellCar(listing3,customer3));

        output.add("There are " + at.countListings() + " cars listed on Autotrader");

    }
}
