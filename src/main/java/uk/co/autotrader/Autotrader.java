package uk.co.autotrader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;


public class Autotrader {
    ArrayList<Listing> carsListedOnAutotrader = new ArrayList<>();
    ArrayList<Listing> boughtCars = new ArrayList<>();
    ArrayList<Retailer> addRetailer = new ArrayList<>();
    ArrayList<Customer> addCustomer = new ArrayList<>();
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
        } else {
            output.add(customer.getCustomerName() + " changed their mind about buying " + listing.vehicleName);
        }
    }

    public void addRetailer(Retailer retailer) {
        addRetailer.add(retailer);
    }

    public void addCustomer(Customer customer) {
        addCustomer.add(customer);
    }

    public void browseCars(String filter) {
        Stream<Listing> carsStream = carsListedOnAutotrader.stream();
        switch (filter) {
            case ("priceLow") -> carsStream = carsStream.sorted(Comparator.comparing(Listing::getPrice));
            case ("priceHigh") -> carsStream = carsStream.sorted(Comparator.comparing(Listing::getPrice).reversed());
            case ("age") -> carsStream = carsStream.sorted(Comparator.comparing(Listing::getPrice).reversed());
        }
        carsStream.forEach(car ->
                output.add(car.getOwner().getRetailerName() + " has listed a " + car.getDescription() + " on Autotrader."));
    }

    public Retailer findRetailerByName(String name) {
        for (Retailer retailer : addRetailer) {
            if (name.equals(retailer.getRetailerName())) {
                return retailer;
            }
        }
        return null;
    }

    public Customer findCustomerByName(String name) {
        for (Customer customer : addCustomer) {
            if (name.equals(customer.getCustomerName())) {
                return customer;
            }
        }
        return null;
    }

    public Listing findListingByName(String name) {
        for (Listing listing : carsListedOnAutotrader) {
            if (name.equals(listing.vehicleName)) {
                return listing;
            }
        }
        return null;
    }

}
