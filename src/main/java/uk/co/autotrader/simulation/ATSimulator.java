package uk.co.autotrader.simulation;

import uk.co.autotrader.model.*;
import uk.co.autotrader.service.Autotrader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ATSimulator {

    private final Autotrader autotrader;
    Random randomNoSeed = new Random();
    NoiseLevelUtil noiseLevelUtil = new NoiseLevelUtil();
    List<String> vehicles;
    private final ArrayList<String> output;

    public ATSimulator(Autotrader autotrader,ArrayList<String> output) {
        this.autotrader = autotrader;
        this.output = output;
        vehicles = List.of("Fiat 500", "Mercedes Benz C class", "Mini Cooper", "A red van", "Audi A3", "Ford Fiesta");
        new SeededData(autotrader);
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
            Retailer retailerChosen = autotrader.getRetailers().get(randomNoSeed.nextInt(autotrader.getRetailers().size()));
            autotrader.addListing(new Listing(vehicleChosen, retailerChosen));
        }

        List<Listing> browseListings = autotrader.browseCars(sort);
        browseListings.forEach(listing -> output.add(listing.getDescription()));
        output.add("**********************");
        output.add("CAR PURCHASES:");

        if (autotrader.countListings() > 1) {
            for (int i = 0; i < randomAmount; i++) {
                Listing listingChosen = autotrader.getCarsListedOnAutotrader().get(randomNoSeed.nextInt(autotrader.getCarsListedOnAutotrader().size()));
                Customer customerChosen = autotrader.getCustomers().get(randomNoSeed.nextInt(autotrader.getCustomers().size()));
                String buyingStatus = autotrader.sellCar(listingChosen, customerChosen);
                output.add(customerChosen.getCustomerName() + " - " + listingChosen.getVehicleName() + " - " + buyingStatus);
            }
        }

        output.add("**********************");
        output.add("\n");
        int count = autotrader.countListings();
        if (count==1) output.add("There is " + count + " car listed on Autotrader");
        else output.add("There are " + count + " cars listed on Autotrader.");
        autotrader.browseCars(sort);
    }

    public void summary(int numberOfDays,Sort sort) {
        output.add("**********************");
        output.add("Performance for last " + numberOfDays + " days");
        output.add("Total sold cars: " + autotrader.getBoughtCars().size());
        output.add("Remaining unsold listings:");
        autotrader.browseCars(sort);
    }

}
