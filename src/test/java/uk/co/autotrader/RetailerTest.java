package uk.co.autotrader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RetailerTest {

    @Test
    void checkGetRetailerNameReturnsName() {
        Retailer retailer = new Retailer("Eman");
        assertEquals("Eman",retailer.getRetailerName());
    }
}