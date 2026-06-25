package uk.co.autotrader;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AutotraderTest {
    Autotrader at = new Autotrader(new ArrayList<>());
    Retailer retailer1 = new Retailer("Eman");
    Retailer retailer2 = new Retailer("Diya");
    Customer customer1 = new Customer("Eman");
    Listing listing1 = new Listing("Car",retailer1);
    Listing listing2 = new Listing("Bike",retailer2);
    Listing listing3 = new Listing("Bus",new Retailer("Asim"));

    @Test
    void givenAddRetailer_thenRetailerAddedToList() {
        at.addRetailer(retailer1);
        assertTrue(at.getRetailers().contains(retailer1));
    }

    @Test
    void givenAddCustomer_thenCustomerAddedToList() {
        at.addCustomer(customer1);
        assertTrue(at.getCustomers().contains(customer1));
    }

    @Test
    void givenAddListing_thenListingAddedToList() {
        at.addListing(listing1);
        assertTrue(at.carsListedOnAutotrader.contains(listing1));
    }

    @Test
    void givenListingsAdded_thenCountListingsReturnsSumOfListing(){
        at.addListing(listing1);
        at.addListing(listing2);
        assertEquals(2,at.countListings());
    }

    @Test
    void givenSellingACar_whenBuyingChanceMoreThan50_thenCarIsSold() {
        at.addListing(listing1);
        assertEquals(listing1,at.carsListedOnAutotrader.getFirst());
        at.sellCar(listing1,customer1,60);
        assertEquals(0,at.carsListedOnAutotrader.size());
        assertEquals(listing1,at.getBoughtCars().getFirst());
    }

    @Test
    void givenSellingACar_whenBuyingChanceLessThan50_thenCarIsNotSold(){
        at.addListing(listing1);
        assertEquals(listing1,at.carsListedOnAutotrader.getFirst());
        at.sellCar(listing1,customer1, 40);
        assertEquals(1,at.carsListedOnAutotrader.size());
        assertEquals(0,at.getBoughtCars().size());
    }

    @Test
    void givenRetailerExists_whenFindRetailer_thenReturnRetailer() {
        at.addRetailer(retailer1);
        assertEquals(retailer1,at.findRetailerByName("Eman"));
    }

    @Test
    void givenRetailerDoesntExist_whenFindRetailer_thenReturnNull() {
        assertNull(at.findRetailerByName("Retailer that doesn't exist"));
    }

    @Test
    void givenCustomerExists_whenFindCustomer_thenReturnCustomer() {
        at.addCustomer(customer1);
        assertEquals(customer1,at.findCustomerByName("Eman"));
    }

    @Test
    void givenCustomerDoesntExist_whenFindCustomer_thenReturnNull() {
        assertNull(at.findCustomerByName("Customer that doesn't exist"));
    }

    @Test
    void givenListingExists_whenFindListing_thenReturnListing() {
        at.addListing(listing1);
        assertEquals(listing1,at.findListingByName("Car"));
    }

    @Test
    void givenListingDoesntExist_whenFindListing_thenReturnNull() {
        assertNull(at.findListingByName("Listing that doesn't exist"));
    }

    @Test
    void givenSortByPrice_whenBrowseCars_thenCarsAreSortedByPriceFromLow() {
        at.addListing(listing1);
        at.addListing(listing2);
        at.addListing(listing3);
        listing1.setPrice(500);
        listing2.setPrice(1000);
        listing3.setPrice(750);

        List<Listing> sortedList = List.of(listing1,listing3,listing2);
        assertEquals(sortedList,at.browseCars(Sort.PRICE_LOW_TO_HIGH));
    }

    @Test
    void givenSortByPriceHigh_whenBrowseCars_thenCarsAreSortedByPriceFromHigh() {
        at.addListing(listing1);
        at.addListing(listing2);
        at.addListing(listing3);
        listing1.setPrice(500);
        listing2.setPrice(1000);
        listing3.setPrice(750);

        List<Listing> sortedList = List.of(listing2,listing3,listing1);
        assertEquals(sortedList,at.browseCars(Sort.PRICE_HIGH_TO_LOW));
    }

    @Test
    void givenSortByAge_whenBrowseCars_thenCarsAreSortedByAgeNewest() {
        at.addListing(listing1);
        at.addListing(listing2);
        at.addListing(listing3);
        listing1.setYear("2000");
        listing2.setYear("1900");
        listing3.setYear("2026");

        List<Listing> sortedList = List.of(listing3,listing1,listing2);
        assertEquals(sortedList,at.browseCars(Sort.AGE));
    }
}
