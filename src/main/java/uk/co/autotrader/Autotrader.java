package uk.co.autotrader;

import java.util.ArrayList;


public class Autotrader {
    ArrayList<Listing> carsListedOnAutotrader = new ArrayList<>();
    ArrayList<Listing> boughtCars = new ArrayList<>();
    private ArrayList<String> output = new ArrayList<>();

    public Autotrader(ArrayList<String> output) {
        this.output = output;
    }

    public void addListing(Listing listing, Retailer retailer) {
        carsListedOnAutotrader.add(listing);
        output.add(retailer.getRetailerName() + " has listed a " + listing.vehicle + " on Autotrader.");
    }

    public int countListings() {
        return carsListedOnAutotrader.size();
    }

    public void sellCar(Listing listing, Customer customer) {
        for (Listing car: carsListedOnAutotrader){
            if ((listing.vehicle).equals(car.vehicle)){
                boughtCars.add(listing);
            }
        }
        for (Listing boughtCar: boughtCars) {
            carsListedOnAutotrader.remove(boughtCar);
        }
        output.add(customer.getCustomerName() + " has bought the car " + listing.vehicle + " on Autotrader.");
    }


}
