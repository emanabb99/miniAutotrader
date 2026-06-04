package uk.co.autotrader;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MenuTest {
    MainMenu mainMenu = new MainMenu();

    @Test
    void checkDisplayRetailerIfRetailerNotInList() {
        mainMenu.simulator.outputSimulation(1);
        boolean retailerFound = mainMenu.findRetailer("Retailer that does not exist");
        assertFalse(retailerFound);
    }

    @Test
    void checkDisplayRetailerIfRetailerInList() {
        mainMenu.simulator.outputSimulation(1);
        boolean retailerFound = mainMenu.findRetailer("Bob's and Belle's Bangers");
        assertTrue(retailerFound);
    }

    @Test
    void checkRetailerHasListings() {
        mainMenu.simulator.outputSimulation(1);
        List<Listing> listings = mainMenu.displayListings("Ol' Granny Guardrails");
        assertEquals(listings.get(0).vehicle,"Robin Reliant");
    }

    @Test
    void checkRetailerExistsButHasNoActiveListings() {
        mainMenu.simulator.outputSimulation(1);
        boolean retailerFound = mainMenu.findRetailer("Big Buck's Best Deals");
        assertTrue(retailerFound);

        List<Listing> listings = mainMenu.displayListings("Big Buck's Best Deals");
        assertTrue(listings.isEmpty());
    }

}