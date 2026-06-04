package uk.co.autotrader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


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

}