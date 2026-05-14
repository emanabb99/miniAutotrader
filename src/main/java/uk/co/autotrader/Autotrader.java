package uk.co.autotrader;

import java.util.ArrayList;


public class Autotrader {
    ArrayList<Listing> carsListedOnAutotrader = new ArrayList<>();
    ArrayList<Listing> boughtCars = new ArrayList<>();
    private ArrayList<String> output = new ArrayList<>();

    public Autotrader(ArrayList<String> output) {
        this.output = output;
    }

    public void addListing(Listing listing) {
        carsListedOnAutotrader.add(listing);
    }

    public void countListings() {
        int numberOfListedCars = carsListedOnAutotrader.size();
        output.add("There are " + numberOfListedCars + " cars listed on Autotrader.");
    }

    public void sellCar(Listing listing, Customer customer) {
        for (Listing car : carsListedOnAutotrader){
            if ((listing.vehicle).equals(car.vehicle)){
                boughtCars.add(listing);
            }
        }
        for (Listing boughtCar : boughtCars) {
            carsListedOnAutotrader.remove(boughtCar);
        }
        output.add(customer.getCustomerName() + " has bought the car " + listing.vehicle + " on Autotrader.");
    }

    public void browseCars(){
        output.add("**********************");
        output.add("CAR LISTINGS:");
        for (Listing car : carsListedOnAutotrader){
            output.add(car.owner.getRetailerName() + " has listed a " + car.vehicle + " on Autotrader.");
        }
    }

}
