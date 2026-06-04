package uk.co.autotrader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListingTest {

    @Test
    void checkGetOwnerReturnsListingOwner() {
        Retailer retailer = new Retailer("Eman");
        Listing listing = new Listing("Fiat 500",retailer);
        assertEquals(retailer,listing.getOwner());
    }
}
