package uk.co.autotrader.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListingTest {

    @Test
    void checkGetOwnerReturnsListingOwner() {
        Retailer retailer = new Retailer("Eman");
        Listing listing = new Listing("Fiat 500",retailer);
        assertEquals(retailer,listing.getRetailer());
    }

    @Test
    void checkGetYearReturnsYearInRightFormatAndRightRange() {
        Retailer retailer = new Retailer("Eman");
        Listing listing = new Listing("Fiat 500",retailer);
        assertTrue(listing.getYear().matches("^\\d{4}$"));
        int year = Integer.parseInt(listing.getYear());
        assertTrue(year <= 2026 && year >= 1886);
    }

    @Test
    void checkGetPriceReturnsPriceThatMatchesPriceOptions() {
        Retailer retailer = new Retailer("Eman");
        Listing listing = new Listing("Fiat 500",retailer);
        List<Integer> prices = List.of(1000,3000,6000,15000);
        assertFalse(prices.contains(listing.getPrice()));
    }

    @Test
    void checkGenerateRandomCategoryGeneratesTypeCategory() {
        Retailer retailer = new Retailer("Eman");
        Listing listing = new Listing("Fiat 500", retailer);
        List<Category> categoryLists = Arrays.stream(Category.values()).toList();

        assertTrue(categoryLists.contains(listing.getCategory()));

    }
}
