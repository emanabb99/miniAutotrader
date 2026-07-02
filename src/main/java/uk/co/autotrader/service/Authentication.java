package uk.co.autotrader.service;

import uk.co.autotrader.model.Retailer;

public class Authentication {
    Autotrader autotrader;

    public Authentication(Autotrader autotrader) {
        this.autotrader = autotrader;
    }

    public Retailer verifyRetailerEmail(String input) {
        for (Retailer retailer : autotrader.getRetailers()) {
            if (input.equals(retailer.getEmail())) {
                return retailer;
            }
        }
        return null;
    }

    public boolean verifyRetailerPassword(String input, Retailer retailer) {
        return retailer.verifyPassword(input);
    }
}
