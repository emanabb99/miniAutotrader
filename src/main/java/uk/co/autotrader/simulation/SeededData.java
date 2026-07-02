package uk.co.autotrader.simulation;

import uk.co.autotrader.model.Customer;
import uk.co.autotrader.model.Retailer;
import uk.co.autotrader.service.Autotrader;

public class SeededData {

    public SeededData(Autotrader autotrader) {
        autotrader.addRetailer(new Retailer("Bob's and Belle's Bangers","bob.com","Bob123"));
        autotrader.addRetailer(new Retailer("Big Buck's Best Deals","bucks.co.uk","BB123"));
        autotrader.addRetailer(new Retailer("Ol' Granny Guardrails","granny.net","Guard123"));
        autotrader.addRetailer(new Retailer("Eman's hot wheels","eman_abbas@hotmail.co.uk","Eman123"));
        autotrader.addRetailer(new Retailer("Another retailer"));
        autotrader.addRetailer(new Retailer("Random retailer"));
        autotrader.addRetailer(new Retailer("Vehicle supermarket"));

        autotrader.addCustomer(new Customer("Megan Moneybanks"));
        autotrader.addCustomer(new Customer("Robin Banks"));
        autotrader.addCustomer(new Customer("Steve McSteve"));
        autotrader.addCustomer(new Customer("Penny Coin"));
        autotrader.addCustomer(new Customer("Johny Bravo"));
        autotrader.addCustomer(new Customer("Barbie"));
        autotrader.addCustomer(new Customer("Dexter"));
    }
}
