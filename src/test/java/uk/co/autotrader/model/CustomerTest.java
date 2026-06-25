package uk.co.autotrader.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    void checkGetCustomerNameReturnsName() {
        Customer customer = new Customer("Eman");
        assertEquals("Eman",customer.getCustomerName());
    }
}
