package uk.co.autotrader.service;

import org.junit.jupiter.api.Test;
import uk.co.autotrader.model.Category;
import uk.co.autotrader.model.Listing;
import uk.co.autotrader.model.Retailer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealerPortalTest {

    @Test
    void checkAddListingAddsListingToAutoTrader() {
        DealerPortal dealerPortal = new DealerPortal(new Retailer("Eman"));
        dealerPortal.addListing("Car");
        dealerPortal.addListing("Bus");
        assertEquals(2, dealerPortal.getAutotrader().countListings());
    }

    @Test
    void checkDisplayListingReturnsRetailerListings() {
        DealerPortal dealerPortal = new DealerPortal(new Retailer("Eman"));
        dealerPortal.addListing("Car");
        dealerPortal.addListing("Bus");
        List<String> myListings = dealerPortal.displayListings();
        assertEquals(2, myListings.size());
    }

    @Test
    void checkDisplayListingDoesntReturnADifferentRetailersListings() {
        DealerPortal dealerPortal = new DealerPortal(new Retailer("Eman"));
        DealerPortal dealerPortal2 = new DealerPortal(new Retailer("Diya"));
        dealerPortal.addListing("Car");
        dealerPortal.addListing("Bus");
        dealerPortal2.addListing("Bike");
        List<String> myListings = dealerPortal2.displayListings();
        assertEquals(1, myListings.size());
    }

    @Test
    void checkEditListingEditsNameCorrectly() {
        Retailer retailer = new Retailer("Eman");
        DealerPortal dealerPortal = new DealerPortal(retailer);
        Listing listing = new Listing("Car",retailer);
        Listing updatedListing = dealerPortal.editListing(listing,1,"Updated car");
        assertEquals("Updated car", updatedListing.getVehicleName());
    }

    @Test
    void checkEditListingEditsPriceCorrectly() {
        Retailer retailer = new Retailer("Eman");
        DealerPortal dealerPortal = new DealerPortal(retailer);
        Listing listing = new Listing("Car",retailer);
        Listing updatedListing = dealerPortal.editListing(listing,2,2000);
        assertEquals(2000, updatedListing.getPrice());
    }

    @Test
    void checkEditListingEditsYearCorrectly() {
        Retailer retailer = new Retailer("Eman");
        DealerPortal dealerPortal = new DealerPortal(retailer);
        Listing listing = new Listing("Car",retailer);
        Listing updatedListing = dealerPortal.editListing(listing,3,"1999");
        assertEquals("1999", updatedListing.getYear());
    }

    @Test
    void checkEditListingEditsCategoryCorrectly() {
        Retailer retailer = new Retailer("Eman");
        DealerPortal dealerPortal = new DealerPortal(retailer);
        Listing listing = new Listing("Car",retailer);
        Listing updatedListing = dealerPortal.editListing(listing,4,"FIRST_CAR");
        assertEquals(Category.FIRST_CAR, updatedListing.getCategory());
    }
}