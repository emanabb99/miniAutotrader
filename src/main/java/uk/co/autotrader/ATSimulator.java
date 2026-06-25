package uk.co.autotrader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ATSimulator {

    private final ArrayList<String> output = new ArrayList<>();
    Autotrader at = new Autotrader(output);
    Random randomNoSeed = new Random();
    NoiseLevelUtil noiseLevelUtil = new NoiseLevelUtil();
    List<String> vehicles;

    ATSimulator() {
        vehicles = List.of("Fiat 500", "Mercedes Benz C class", "Mini Cooper", "A red van", "Audi A3", "Ford Fiesta");
        at.addRetailer(new Retailer("Bob's and Belle's Bangers"));
        at.addRetailer(new Retailer("Big Buck's Best Deals"));
        at.addRetailer(new Retailer("Ol' Granny Guardrails"));
        at.addRetailer(new Retailer("Eman's hot wheels"));
        at.addRetailer(new Retailer("Another retailer"));
        at.addRetailer(new Retailer("Random retailer"));
        at.addRetailer(new Retailer("Vehicle supermarket"));

        at.addCustomer(new Customer("Megan Moneybanks"));
        at.addCustomer(new Customer("Robin Banks"));
        at.addCustomer(new Customer("Steve McSteve"));
        at.addCustomer(new Customer("Penny Coin"));
        at.addCustomer(new Customer("Johny Bravo"));
        at.addCustomer(new Customer("Barbie"));
        at.addCustomer(new Customer("Dexter"));
    }

    public List<String> outputSimulation(int day, NoiseLevel noiseLevel, boolean summary, Sort sort) {
        if (summary) {
            summary(day,sort);
            for (String line : output) {
                System.out.println(line);
            }
        } else {
            runSimulationDayRandom(day,sort);
            List<String> subList = noiseLevelUtil.getPrintArrayBasedOnNoise(noiseLevel, output);
            for (String line : subList) {
                System.out.println(line);
            }
        }
        return output;
    }

    public void runSimulationDayRandom(int day, Sort sort) {
        output.add("********************** Day " + day);
        output.add("Welcome to Mini Autotrader!" + "\n");

        int randomAmount = randomNoSeed.nextInt(5) + 1;
        for (int i = 0; i < randomAmount; i++) {
            String vehicleChosen = vehicles.get(randomNoSeed.nextInt(vehicles.size()));
            Retailer retailerChosen = at.getRetailers().get(randomNoSeed.nextInt(at.getRetailers().size()));
            at.addListing(new Listing(vehicleChosen, retailerChosen));
        }

        at.browseCars(sort);
        output.add("**********************");
        output.add("CAR PURCHASES:");

        if (at.countListings() > 1) {
            for (int i = 0; i < randomAmount; i++) {
                int buyingProbability = randomNoSeed.nextInt(101);
                Listing listingChosen = at.getCarsListedOnAutotrader().get(randomNoSeed.nextInt(at.getCarsListedOnAutotrader().size()));
                Customer customerChosen = at.getCustomers().get(randomNoSeed.nextInt(at.getCustomers().size()));
                at.sellCar(listingChosen, customerChosen, buyingProbability);
            }
        }

        output.add("**********************");
        output.add("\n");
        int count = at.countListings();
        if (count==1) output.add("There is " + count + " car listed on Autotrader");
        else output.add("There are " + count + " cars listed on Autotrader.");
        at.browseCars(sort);
    }

    public void summary(int numberOfDays,Sort sort) {
        output.add("**********************");
        output.add("Performance for last " + numberOfDays + " days");
        output.add("Total sold cars: " + at.getBoughtCars().size());
        output.add("Remaining unsold listings:");
        at.browseCars(sort);
    }

}
