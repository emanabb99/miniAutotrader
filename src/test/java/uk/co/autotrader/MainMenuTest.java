package uk.co.autotrader;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MainMenuTest {
    MainMenu mainMenu = new MainMenu();

    @Test
    void checkFindRetailerIfRetailerNotInList() {
        mainMenu.simulator.outputSimulation(1,NoiseLevel.NORMAL);
        boolean retailerFound = mainMenu.findRetailer("Retailer that does not exist");
        assertFalse(retailerFound);
    }

    @Test
    void checkFindRetailerIfRetailerInList() {
        mainMenu.simulator.outputSimulation(1,NoiseLevel.NORMAL);
        boolean retailerFound = mainMenu.findRetailer("Bob's and Belle's Bangers");
        assertTrue(retailerFound);
    }

    @Test
    void checkRetailerHasListings() {
        mainMenu.simulator.outputSimulation(1,NoiseLevel.NORMAL);
        List<Listing> listings = mainMenu.displayListings("Ol' Granny Guardrails");
        assertEquals("Robin Reliant",listings.getFirst().vehicleName);
    }

    @Test
    void checkRetailerExistsButHasNoActiveListings() {
        mainMenu.simulator.outputSimulation(1,NoiseLevel.NORMAL);
        boolean retailerFound = mainMenu.findRetailer("Big Buck's Best Deals");
        assertTrue(retailerFound);

        List<Listing> listings = mainMenu.displayListings("Big Buck's Best Deals");
        assertTrue(listings.isEmpty());
    }

    @Test
    void checkFindCustomerIfCustomerNotInList(){
        mainMenu.simulator.outputSimulation(1,NoiseLevel.NORMAL);
        boolean customerFound = mainMenu.findCustomer("Customer that doesn't exist");
        assertFalse(customerFound);
    }

    @Test
    void checkFindCustomerIfCustomerInList(){
        mainMenu.simulator.outputSimulation(1,NoiseLevel.NORMAL);
        boolean customerFound = mainMenu.findCustomer("Megan Moneybanks");
        assertTrue(customerFound);
    }

    @Test
    void checkAddRetailerWorks() {
        Retailer retailer = new Retailer("Eman");
        mainMenu.addRetailer(retailer);
        assertEquals(retailer,mainMenu.simulator.at.retailers.getFirst());
    }


}