package uk.co.autotrader.console;

import org.junit.jupiter.api.Test;
import uk.co.autotrader.model.Customer;
import uk.co.autotrader.model.Listing;
import uk.co.autotrader.model.Retailer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MainMenuTest {
    static MainMenu mainMenu;
    Retailer retailer1 = new Retailer("Eman");
    Listing listing1 = new Listing("Car",retailer1);
    static {
        mainMenu = new MainMenu();
    }

    @Test
    void checkRetailerHasListings() {
        mainMenu.autotrader.addListing(listing1);
        List<Listing> listings = mainMenu.displayListings(retailer1);
        assertEquals("Car",listings.getFirst().getVehicleName());
    }

    @Test
    void checkRetailerExistsButHasNoActiveListings() {
        Retailer retailer2 = new Retailer("Retailer");
        mainMenu.addRetailer(retailer2);
        List<Listing> listings = mainMenu.displayListings(retailer2);
        assertTrue(listings.isEmpty());
    }

    @Test
    void checkAddRetailerWorks() {
        mainMenu.addRetailer(retailer1);
        assertEquals(retailer1.getRetailerName(),mainMenu.autotrader.findRetailerByName("Eman").getRetailerName());
    }

}