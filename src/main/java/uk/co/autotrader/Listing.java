package uk.co.autotrader;

public class Listing {
    String vehicle;
    Retailer owner;

    public Listing(String vehicle, Retailer owner){
        this.vehicle = vehicle;
        this.owner = owner;
    }

    public Retailer getOwner() {
        return owner;
    }
}
