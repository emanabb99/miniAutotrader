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

    public int countListings() {
        return carsListedOnAutotrader.size();
    }

    public void sellCar(Listing listing, Customer customer, int buyingChance) {
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }
        if (buyingChance > 50) {
            for (Listing car : carsListedOnAutotrader) {
                if ((listing.vehicleName).equals(car.vehicleName)) {
                    boughtCars.add(listing);
                }
            }
            for (Listing boughtCar : boughtCars) {
                carsListedOnAutotrader.remove(boughtCar);
            }
            output.add(customer.getCustomerName() + " has bought the car " + listing.vehicleName + " on Autotrader.");
        }
        else {
            output.add(customer.getCustomerName() + " changed their mind about buying " + listing.vehicleName);
        }
    }

    public void addRetailer(Retailer retailer) {
        retailers.add(retailer);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void browseCars(){
        for (Listing car : carsListedOnAutotrader){
            output.add(car.getOwner().getRetailerName() + " has listed a " + car.getDescription() + " on Autotrader.");
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
            if (name.equals(listing.vehicleName)){
                return listing;
            }
        }
        return null;
    }

}
