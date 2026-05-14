package uk.co.autotrader;

public class Retailer {
    private String retailerName;
    Listing listing;

    public Retailer(String retailerName){
        this.retailerName = retailerName;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public String sellCar(Listing listing, Customer customer) {
        for (Listing car: listing.carsListedOnAutotrader){
            if ((car.vehicle).equals(listing.vehicle)){
                listing.boughtCars.add(listing);
            }
        }
        for (Listing boughtCar: listing.boughtCars) {
            listing.carsListedOnAutotrader.remove(boughtCar);
        }
        return customer.getCustomerName() + " has bought the car " + listing.vehicle + ".";



    }

}
