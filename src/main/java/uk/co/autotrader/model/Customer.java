package uk.co.autotrader.model;

import java.util.Random;

public class Customer {
    private static final Random random = new Random();
    private final String customerName;
    private int minBudget;
    private int maxBudget;

    public Customer(String customerName){
        this.customerName = customerName;
        this.maxBudget = calculateMaxBudget();
        this.minBudget = calculateMinBudget(maxBudget);
    }

    public String getCustomerName() {
        return customerName;
    }

    private int calculateMaxBudget() {
        return random.nextInt(15001);
    }

    private int calculateMinBudget(int maxBudget) {
        return random.nextInt(maxBudget);
    }

    public int getMinBudget(){
        return minBudget;
    }

    public int getMaxBudget() {
        return maxBudget;
    }

    public void setMinBudget(int minBudget){
        if (minBudget>maxBudget) {
            throw new RuntimeException("Minimum budget cannot be more than maximum budget");
        }
        else {
            this.minBudget = minBudget;
        }
    }

    public void setMaxBudget(int maxBudget) {
        if (maxBudget<minBudget) {
            throw new RuntimeException("Maximum budget cannot be less than minimum budget");
        }
        else {
            this.maxBudget = maxBudget;
        }
    }
}
