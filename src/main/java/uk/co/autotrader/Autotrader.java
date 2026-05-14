package uk.co.autotrader;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Autotrader {
    ArrayList<Listing> carsListedOnAutotrader = new ArrayList<>();
    ArrayList<Listing> boughtCars = new ArrayList<>();


    public void addListing(Listing listing) {
        carsListedOnAutotrader.add(listing);
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
        return customer.getCustomerName() + " has bought the car " + listing.vehicle + ".";
    }



}
