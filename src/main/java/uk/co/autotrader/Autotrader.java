package uk.co.autotrader;

import java.util.ArrayList;


public class Autotrader {
    ArrayList<Listing> carsListedOnAutotrader = new ArrayList<>();
    ArrayList<Listing> boughtCars = new ArrayList<>();
    ArrayList<Retailer> retailers = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<String> output;

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

    public void addRetailer(Retailer retailer) {
        retailers.add(retailer);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void browseCars(){
        output.add("**********************");
        output.add("CAR LISTINGS:");
        for (Listing car : carsListedOnAutotrader){
            output.add(car.owner.getRetailerName() + " has listed a " + car.vehicle + " on Autotrader.");
        }
    }

    public Retailer findRetailerByName(String name){
        for (Retailer retailer : retailers) {
            if (name.equals(retailer.getRetailerName())) {
                return retailer;
            }
        }
        return null;
    }

    public Customer findCustomerByName(String name){
        for (Customer customer: customers){
            if (name.equals(customer.getCustomerName())){
                return customer;
            }
        }
        return null;
    }

    public Listing findListingByName(String name) {
        for (Listing listing: carsListedOnAutotrader) {
            if (name.equals(listing.vehicle)){
                return listing;
            }
        }
        return null;
    }

}
