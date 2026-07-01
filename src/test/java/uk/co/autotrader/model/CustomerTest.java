package uk.co.autotrader.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {

    @Test
    void checkGetCustomerNameReturnsName() {
        Customer customer = new Customer("Eman");
        assertEquals("Eman",customer.getCustomerName());
    }

    @Test
    void givenCalculateMinBudget_whenCalculateMaxBudget_MinBudgetIsAlwaysLessThanMaxBudget() {
        Customer customer = new Customer("Eman");
        int maxBudget = customer.calculateMaxBudget();
        int minBudget = customer.calculateMinBudget(maxBudget);
        assertTrue(minBudget<maxBudget);
    }
}
