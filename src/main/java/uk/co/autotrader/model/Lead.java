package uk.co.autotrader.model;

import java.util.List;
import java.util.Random;

public class Lead {
    private final Customer customer;
    private final Retailer retailer;
    private final Listing listing;
    private final String message;

    public Lead(Customer customer, Listing listing) {
        this.customer = customer;
        this.listing = listing;
        this.retailer = listing.getRetailer();
        this.message = generateLeadMessage();
    }

    private List<String> generateQuery() {
        return List.of("Do you offer click and collect?","Is there any discount?","Does this have cruise control?");
    }

    private String generateLeadMessage() {
        Random random = new Random();
        List<String> messagePool = generateQuery();
        String query = messagePool.get(random.nextInt(messagePool.size()));
        return "Hello, my name is " + customer.getCustomerName() + ". I am interested" +
                " in the following vehicle:\n" + listing.getDescription() + query + "\n";
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public Listing getListing() {
        return listing;
    }

    public String getMessage() {
        return message;
    }
}
