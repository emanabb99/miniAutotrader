package uk.co.autotrader;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MainMenuTest {
    static MainMenu mainMenu;
    static {
        mainMenu = new MainMenu();
    }
    public static void createOutput() {
        mainMenu.simulator.outputSimulation(1,NoiseLevel.NORMAL,false,null);
    }

    @Test
    void checkFindRetailerIfRetailerNotInList() {
        boolean retailerFound = mainMenu.findRetailer("Retailer that does not exist");
        assertFalse(retailerFound);
    }

    @Test
    void checkFindRetailerIfRetailerInList() {
        boolean retailerFound = mainMenu.findRetailer("Bob's and Belle's Bangers");
        assertTrue(retailerFound);
    }

    @Test
    void checkRetailerHasListings() {
        mainMenu.simulator.at.addListing(new Listing("car",new Retailer("Eman")));
        List<Listing> listings = mainMenu.displayListings("Eman");
        assertEquals("car",listings.getFirst().vehicleName);
    }

    @Test
    void checkRetailerExistsButHasNoActiveListings() {
        boolean retailerFound = mainMenu.findRetailer("Big Buck's Best Deals");
        assertTrue(retailerFound);

        List<Listing> listings = mainMenu.displayListings("Big Buck's Best Deals");
        assertTrue(listings.isEmpty());
    }

    @Test
    void checkFindCustomerIfCustomerNotInList(){
        boolean customerFound = mainMenu.findCustomer("Customer that doesn't exist");
        assertFalse(customerFound);
    }

    @Test
    void checkFindCustomerIfCustomerInList(){
        boolean customerFound = mainMenu.findCustomer("Megan Moneybanks");
        assertTrue(customerFound);
    }

    @Test
    void checkAddRetailerWorks() {
        Retailer retailer = new Retailer("Eman");
        mainMenu.addRetailer(retailer);
        assertEquals(retailer,mainMenu.simulator.at.findRetailerByName("Eman"));
    }

}