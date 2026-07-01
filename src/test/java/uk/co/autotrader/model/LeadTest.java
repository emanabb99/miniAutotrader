package uk.co.autotrader.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class LeadTest {

    @Test
    void checkGenerateLeadMessage() {
        Customer customer1 = new Customer("Eman");
        Retailer retailer1 = new Retailer("Diya");
        Listing listing1 = new Listing("Car",retailer1);
        Lead lead = new Lead(customer1,listing1);
        assertFalse(lead.generateLeadMessage().isEmpty());
    }

}