package uk.co.autotrader;

import java.util.ArrayList;

public class Listing {
    ArrayList<Listing> carsListedOnAutotrader = new ArrayList<>();
    ArrayList<Listing> boughtCars = new ArrayList<>();
    String vehicle;
    Retailer owner;

    public Listing(String vehicle, Retailer owner){
        this.vehicle = vehicle;
        this.owner = owner;
        listingAdded(this);
    }

    public void listingAdded(Listing listing) {
        carsListedOnAutotrader.add(listing);
    }


}
