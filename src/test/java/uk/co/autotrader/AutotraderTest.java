package uk.co.autotrader;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        assertEquals(listing,at.carsListedOnAutotrader.getFirst());

    }

    @Test
    void checkCountListingsReturnsCorrectNumber(){
        Listing listing = new Listing("Car",new Retailer("Eman"));
        Listing listing2 = new Listing("Bike",new Retailer("Diya"));
        at.addListing(listing);
        at.addListing(listing2);
        assertEquals(2,at.countListings());
    }

    @Test
    void checkSellCarsIfBuyingChanceOver50() {
        Random random = new Random(70);
        Listing listing = new Listing("Car",new Retailer("Eman"));
        at.addListing(listing);
        Customer customer = new Customer("Diya");
        assertEquals(listing,at.carsListedOnAutotrader.getFirst());
        System.out.println(random.nextInt(51)+50);
        at.sellCar(listing,customer,random.nextInt(51)+50);
        assertEquals(0,at.carsListedOnAutotrader.size());
        assertEquals(listing,at.boughtCars.getFirst());
    }

    @Test
    void checkSellCarsIfBuyingChanceLessThan50(){
        Random random = new Random(10);
        Listing listing = new Listing("Car",new Retailer("Eman"));
        at.addListing(listing);
        Customer customer = new Customer("Diya");
        assertEquals(listing,at.carsListedOnAutotrader.getFirst());
        System.out.println(random.nextInt(51));
        at.sellCar(listing,customer, random.nextInt(51));
        assertEquals(1,at.carsListedOnAutotrader.size());
        assertEquals(0,at.boughtCars.size());
    }

    @Test
    void checkFindRetailerByNameIfRetailerInList() {
        Retailer retailer = new Retailer("Eman");
        at.addRetailer(retailer);
        assertEquals(retailer,at.findRetailerByName("Eman"));
    }

    @Test
    void checkFindRetailerByNameIfRetailerDoesntExist() {
        assertNull(at.findRetailerByName("Retailer that doesn't exist"));
    }

    @Test
    void checkFindCustomerByNameIfCustomerInList() {
        Customer customer = new Customer("Eman");
        at.addCustomer(customer);
        assertEquals(customer,at.findCustomerByName("Eman"));
    }

    @Test
    void checkFindCustomerByNameIfCustomerDoesntExist() {
        assertNull(at.findCustomerByName("Customer that doesn't exist"));
    }

    @Test
    void checkFindListingByNameIfListingInList() {
        Listing listing = new Listing("Car",new Retailer("Eman"));
        at.addListing(listing);
        assertEquals(listing,at.findListingByName("Car"));
    }

    @Test
    void checkFindListingByNameIfListingDoesntExist() {
        assertNull(at.findListingByName("Customer that doesn't exist"));
    }
}
