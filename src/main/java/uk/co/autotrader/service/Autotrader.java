package uk.co.autotrader.service;

import uk.co.autotrader.model.*;

import java.util.*;
import java.util.stream.Stream;


public class Autotrader {
    private final List<Listing> carsListedOnAutotrader = new ArrayList<>();
    private final List<Listing> boughtCars = new ArrayList<>();
    private final List<Retailer> retailers = new ArrayList<>();
    private final List<Lead> leads = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();

    public void addListing(Listing listing) {
        carsListedOnAutotrader.add(listing);
    }

    public int countListings() {
        return carsListedOnAutotrader.size();
    }

    public String sellCar(Listing listing, Customer customer) {
        int buyingChance;
        Random random = new Random();
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }
        if (listing.getPrice() < customer.getMaxBudget() && listing.getPrice() > customer.getMinBudget()) {
            buyingChance = random.nextInt(101)+50;
        }
        else {
            buyingChance = random.nextInt(50);
        }
        if (buyingChance > 50) {
            if (carsListedOnAutotrader.remove(listing)) {
                boughtCars.add(listing);
            }
            return "SOLD";
        } else {
            leads.add(new Lead(customer,listing));
            return "CANCELLED";
        }
    }

    public List<Lead> getLeads() {
        return List.copyOf(leads);
    }

    public void addRetailer(Retailer retailer) {
        retailers.add(retailer);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Listing> browseCars(Sort sort) {
        Stream<Listing> carsStream = carsListedOnAutotrader.stream();
        carsStream = switch (sort) {
            case PRICE_LOW_TO_HIGH -> carsStream.sorted(Comparator.comparing(Listing::getPrice));
            case PRICE_HIGH_TO_LOW -> carsStream.sorted(Comparator.comparing(Listing::getPrice).reversed());
            case AGE -> carsStream.sorted(Comparator.comparing(Listing::getYear).reversed());
            case DEFAULT -> carsStream;
        };
        return carsStream.toList();
    }

    public Optional<Retailer> findRetailerByName(String name) {
        return retailers.stream().filter(retailer -> name.equals(retailer.getRetailerName())).findFirst();
    }

    public Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (name.equals(customer.getCustomerName())) {
                return customer;
            }
        }
        return null;
    }

    public Listing findListingByName(String name) {
        for (Listing listing : carsListedOnAutotrader) {
            if (name.equals(listing.getVehicleName())) {
                return listing;
            }
        }
        return null;
    }

    public List<Listing> getBoughtCars() {
        return List.copyOf(boughtCars);
    }

    public List<Retailer> getRetailers() {
        return List.copyOf(retailers);
    }

    public List<Customer> getCustomers() {
        return List.copyOf(customers);
    }

    public List<Listing> getCarsListedOnAutotrader() {
        return List.copyOf(carsListedOnAutotrader);
    }
}
