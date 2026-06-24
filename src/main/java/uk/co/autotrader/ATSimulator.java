package uk.co.autotrader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ATSimulator {

    private final ArrayList<String> output = new ArrayList<>();
    Autotrader at = new Autotrader(output);
    Random randomNoSeed = new Random();
    Random random = new Random(70);
    NoiseLevelUtil noiseLevelUtil = new NoiseLevelUtil();
    List<String> vehicles;

    ATSimulator() {
        vehicles = List.of("Fiat 500","Mercedes Benz C class","Mini Cooper","A red van","Audi A3", "Ford Fiesta");
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

    public List<String> outputSimulation(int day, NoiseLevel noiseLevel, boolean summary) {
        if (summary) {
            summary(day);
        }
        if (day==1) {
            runSimulationDay1();
        }
        else {
            runSimulationDayRandom(day);
        }

        List<String> subList = noiseLevelUtil.getPrintArrayBasedOnNoise(noiseLevel,output);
        for (String line: subList) {
            System.out.println(line);
        }
        return output;
    }

    public void runSimulationDay1() {
        output.add("********************** Day 1");
        output.add("Welcome to Mini Autotrader!");

        Listing listing1 = new Listing("1999 Ford Fiesta",at.findRetailerByName("Bob's and Belle's Bangers"));
        at.addListing(listing1);

        Listing listing2 = new Listing("Tesla Model Y",at.findRetailerByName("Big Buck's Best Deals"));
        at.addListing(listing2);

        Listing listing3 = new Listing("Fire Truck",at.findRetailerByName("Big Buck's Best Deals"));
        at.addListing(listing3);

        Listing listing4 = new Listing("Robin Reliant",at.findRetailerByName("Ol' Granny Guardrails"));
        at.addListing(listing4);

        output.add("**********************");
        output.add("CAR LISTINGS:");
        at.browseCars();

        output.add("**********************");

        output.add("CAR PURCHASES:");
        int buying = random.nextInt(51)+50;
        at.sellCar(listing1,at.findCustomerByName("Megan Moneybanks"),buying);
        at.sellCar(listing2,at.findCustomerByName("Robin Banks"),buying);
        at.sellCar(listing3,at.findCustomerByName("Steve McSteve"),buying);

        output.add("**********************");
        int count = at.countListings();
        output.add("There are " + count + " cars listed on Autotrader.");
        at.browseCars();
    }

    public void runSimulationDayRandom(int day) {
        output.add("********************** Day " + day);
        output.add("Welcome to Mini Autotrader!");

        int randomAmount = randomNoSeed.nextInt(5);
        for (int i = 1; i < randomAmount; i++){
            String vehicleChosen = vehicles.get(randomNoSeed.nextInt(vehicles.size()));
            Retailer retailerChosen = at.addRetailer.get(randomNoSeed.nextInt(at.addRetailer.size()));
            at.addListing(new Listing(vehicleChosen,retailerChosen));
        }

        at.browseCars();
        output.add("**********************");
        output.add("CAR PURCHASES:");

        for (int i = 0; i < randomAmount; i++) {
            int buyingProbability = randomNoSeed.nextInt(101);
            Listing listingChosen = at.carsListedOnAutotrader.get(randomNoSeed.nextInt(at.carsListedOnAutotrader.size()));
            Customer customerChosen = at.addCustomer.get(randomNoSeed.nextInt(at.addCustomer.size()));
            at.sellCar(listingChosen,customerChosen,buyingProbability);
        }

        output.add("**********************");
        int count = at.countListings();
        output.add("There are " + count + " cars listed on Autotrader.");
        at.browseCars();
    }

    public void summary(int numberOfDays) {
        output.add("**********************");
        output.add("Performance for last" + numberOfDays +"days");
        output.add("Total sold cars: " + at.boughtCars.size());
        at.browseCars();
    }

}
