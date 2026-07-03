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

    public SaleStatus sellCar(Listing listing, Customer customer) {
        int buyingChance;
        Objects.requireNonNull(listing, "Listing must not be null");
        Objects.requireNonNull(customer, "Customer must not be null");
        int min = customer.getMinBudget();
        int max = customer.getMaxBudget();

        if (listing.getPrice() <= max && listing.getPrice() >= min) {
            buyingChance = 80;
        }
        else if (listing.getPrice() >= (min*0.8) && listing.getPrice() <= (1.2*max)) {
            buyingChance = 40;
        }
        else {
            buyingChance = 10;
        }
        if (buyingChance >= 75) {
            if (carsListedOnAutotrader.remove(listing)) {
                boughtCars.add(listing);
                return SaleStatus.SOLD;
            }
            return SaleStatus.CANCELLED;
        } else if (buyingChance >= 25){
            leads.add(new Lead(customer,listing));
            return SaleStatus.IN_PROGRESS;
        } else {
            return SaleStatus.CANCELLED;
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
        Objects.requireNonNull(sort, "Sort must not be null");
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

    public Optional<Customer> findCustomerByName(String name) {
        return customers.stream().filter(customer -> name.equals(customer.getCustomerName())).findFirst();
    }

    public Optional<Listing> findListingByName(String name) {
        return carsListedOnAutotrader.stream().filter(listing -> name.equals(listing.getVehicleName())).findFirst();
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
