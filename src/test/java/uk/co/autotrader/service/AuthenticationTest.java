package uk.co.autotrader.service;

import org.junit.jupiter.api.Test;
import uk.co.autotrader.model.Retailer;


import static org.junit.jupiter.api.Assertions.*;

class AuthenticationTest {

    @Test
    void checkFindRetailerByEmailReturnsRetailerIfExists() {
        Retailer retailer = new Retailer("Eman","eman.com","Eman123");
        Autotrader autotrader = new Autotrader();
        autotrader.addRetailer(retailer);
        Authentication authentication = new Authentication(autotrader);
        assertTrue(authentication.findRetailerByEmail("eman.com").isPresent());
    }

    @Test
    void checkFindRetailerByEmailReturnsEmptyIfDoesntExist() {
        Autotrader autotrader = new Autotrader();
        Authentication authentication = new Authentication(autotrader);
        assertTrue(authentication.findRetailerByEmail("eman.com").isEmpty());
    }

    @Test
    void checkVerifyPasswordReturnsTrueIfPasswordCorrect() {
        Retailer retailer = new Retailer("Eman","eman.com","Eman123");
        Autotrader autotrader = new Autotrader();
        autotrader.addRetailer(retailer);
        Authentication authentication = new Authentication(autotrader);
        assertTrue(authentication.verifyRetailerPassword("Eman123",retailer));
    }

    @Test
    void checkVerifyPasswordReturnsFalseIfPasswordCorrect() {
        Retailer retailer = new Retailer("Eman","eman.com","Eman123");
        Autotrader autotrader = new Autotrader();
        autotrader.addRetailer(retailer);
        Authentication authentication = new Authentication(autotrader);
        assertFalse(authentication.verifyRetailerPassword("idk",retailer));
    }

}