package uk.co.autotrader;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Autotrader {
    ArrayList<Listing> carsListedOnAutotrader = new ArrayList<>();
    ArrayList<Listing> boughtCars = new ArrayList<>();
    private List<String> output;

    public Autotrader(List<String> output) {
        this.output = output;
    }

    public String addListing(Listing listing, Retailer retailer) {
        carsListedOnAutotrader.add(listing);
        return retailer.getRetailerName() + " has listed a " + listing.vehicle + " on Autotrader.";
    }

    public int countListings() {
        return carsListedOnAutotrader.size();
    }

    public String sellCar(Listing listing, Customer customer) {
        for (Listing car: carsListedOnAutotrader){
            if ((listing.vehicle).equals(car.vehicle)){
                boughtCars.add(listing);
            }
        }
        for (Listing boughtCar: boughtCars) {
            carsListedOnAutotrader.remove(boughtCar);
        }
        return customer.getCustomerName() + " has bought the car " + listing.vehicle + " on Autotrader.";
    }


}
