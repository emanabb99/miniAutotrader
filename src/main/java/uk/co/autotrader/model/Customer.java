package uk.co.autotrader.model;

public class Customer {
    private final String customerName;

    public Customer(String customerName){
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }
}
