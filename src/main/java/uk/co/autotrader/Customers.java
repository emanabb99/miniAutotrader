package uk.co.autotrader;

import java.util.ArrayList;

public class Customers {
    ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
