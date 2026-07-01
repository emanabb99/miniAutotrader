package uk.co.autotrader.model;

import java.util.Random;

public class Customer {
    private final String customerName;

    public Customer(String customerName){
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int calculateMaxBudget() {
        Random random = new Random();
        return random.nextInt(15001);
    }

    public int calculateMinBudget(int maxBudget) {
        Random random = new Random();
        return random.nextInt(maxBudget);
    }
}
