package uk.co.autotrader;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutotraderTest {
    Autotrader at = new Autotrader(new ArrayList<>());

    @Test
    void checkAddRetailer() {
        Retailer retailer1 = new Retailer("Eman");
        Retailer retailer2 = new Retailer("Diya");
        at.addRetailer(retailer1);
        at.addRetailer(retailer2);
        assertEquals(retailer1,at.retailers.get(0));
        assertEquals(retailer2,at.retailers.get(1));
    }

    @Test
    void checkAddCustomer() {
        Customer customer1 = new Customer("Eman");
        Customer customer2 = new Customer("Diya");
        at.addCustomer(customer1);
        at.addCustomer(customer2);
        assertEquals(customer1,at.customers.get(0));
        assertEquals(customer2,at.customers.get(1));
    }

    @Test
    void checkAddListings() {
        Listing listing = new Listing("Car",new Retailer("Eman"));
        at.addListing(listing);
        assertEquals(listing,at.carsListedOnAutotrader.get(0));

    }

    @Test
    void checkCountListingsReturnsCorrectNumber(){
        Listing listing = new Listing("Car",new Retailer("Eman"));
        Listing listing2 = new Listing("Bike",new Retailer("Diya"));
        at.addListing(listing);
        at.addListing(listing2);
        assertEquals(2,at.countListings());
    }
}
