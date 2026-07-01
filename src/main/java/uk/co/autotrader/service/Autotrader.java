package uk.co.autotrader.service;

import uk.co.autotrader.model.Customer;
import uk.co.autotrader.model.Listing;
import uk.co.autotrader.model.Retailer;
import uk.co.autotrader.model.Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


public class Autotrader {
    private final List<Listing> carsListedOnAutotrader = new ArrayList<>();
    private final List<Listing> boughtCars = new ArrayList<>();
    private final List<Retailer> retailers = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();
    private final List<String> output;

    public Autotrader(ArrayList<String> output) {
        this.output = output;
    }

    public void addListing(Listing listing) {
        carsListedOnAutotrader.add(listing);
    }

    public int countListings() {
        return carsListedOnAutotrader.size();
    }

    public String sellCar(Listing listing, Customer customer, int buyingChance) {
        String buyingStatus = "";
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }
        if (buyingChance > 50) {
            for (Listing car : carsListedOnAutotrader) {
                if (listing.equals(car)) {
                    boughtCars.add(listing);
                }
            }
            for (Listing boughtCar : boughtCars) {
                carsListedOnAutotrader.remove(boughtCar);
            }
            buyingStatus = "SOLD";
        } else {
            buyingStatus = "CANCELLED";
        }
        return buyingStatus;
    }

    public void addRetailer(Retailer retailer) {
        retailers.add(retailer);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Listing> browseCars(Sort filter) {
        Stream<Listing> carsStream = carsListedOnAutotrader.stream();
        carsStream = switch (filter) {
            case PRICE_LOW_TO_HIGH -> carsStream.sorted(Comparator.comparing(Listing::getPrice));
            case PRICE_HIGH_TO_LOW -> carsStream.sorted(Comparator.comparing(Listing::getPrice).reversed());
            case AGE -> carsStream.sorted(Comparator.comparing(Listing::getYear).reversed());
            case null -> carsStream;
        };
        List<Listing> carList = carsStream.toList();
        carList.forEach(car -> output.add(car.getDescription()));
        return carList;
    }

    public Retailer findRetailerByName(String name) {
        for (Retailer retailer : retailers) {
            if (name.equals(retailer.getRetailerName())) {
                return retailer;
            }
        }
        return null;
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
