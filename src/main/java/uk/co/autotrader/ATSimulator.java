package uk.co.autotrader;

import java.util.ArrayList;
import java.util.List;

public class ATSimulator {

    private final ArrayList<String> output = new ArrayList<>();
    private final ArrayList<String> carsListedOnAutotrader = new ArrayList<>();
    private final ArrayList<String> boughtCars = new ArrayList<>();

    public List<String> outputSimulation() {
        runSimulation();

        for (String line: output) {
            System.out.println(line);
        }

        return output;
    }

    private void runSimulation() {
        output.add("Welcome to Mini Autotrader!");
        Retailer bobsBelles = new Retailer("Bob's and Belle's Bangers");
        Retailer bigBucks = new Retailer("Big Buck’s Best Deals");
        Retailer olGranny = new Retailer("Ol’ Granny Guardrails");

        Customer customer1 = new Customer("Megan MoneyBanks");
        Customer customer2 = new Customer("Robin Banks");
        Customer customer3 = new Customer("Steve McSteve");

        Listing listing1 = new Listing("1999 Ford Fiesta",bobsBelles);
        output.add(bobsBelles.getRetailerName() + " has listed a " + listing1.vehicle + " on Autotrader.");
        Listing listing2 = new Listing("Tesla Model Y",bigBucks);
        output.add(bigBucks.getRetailerName() + " has listed a " + listing2.vehicle + " on Autotrader.");
        Listing listing3 = new Listing("Fire Truck",bigBucks);
        output.add(bigBucks.getRetailerName() + " has listed a " + listing3.vehicle + " on Autotrader.");
        Listing listing4 = new Listing("Robin Reliant",olGranny);
        output.add(olGranny.getRetailerName() + " has listed a " + listing4.vehicle + " on Autotrader.");

        ;
//        for (String listing: carsListedOnAutotrader){
//            if (listing.equals("1999 Ford Fiesta")){
//                output.add(carBuyerName + " has bought the car " + listing + ".");
//                boughtCars.add(listing);
//            }
//        }
//        for (String boughtCar: boughtCars) {
//            if (carsListedOnAutotrader.contains(boughtCar)) {
//                int index = carsListedOnAutotrader.indexOf(boughtCar);
//                carsListedOnAutotrader.remove(index);
//            }
//        }
//        output.add("There are currently " + carsListedOnAutotrader.size() + " cars listed on Autotrader");
    }
}
