package uk.co.autotrader.service;

import uk.co.autotrader.model.Retailer;

import java.util.Optional;

public class Authentication {
    Autotrader autotrader;

    public Authentication(Autotrader autotrader) {
        this.autotrader = autotrader;
    }

    public Optional<Retailer> findRetailerByEmail(String input) {
        for (Retailer retailer : autotrader.getRetailers()) {
            if (input.equals(retailer.getEmail())) {
                return Optional.of(retailer);
            }
        }
        return Optional.empty();
    }

    public boolean verifyRetailerPassword(String input, Retailer retailer) {
        return retailer.verifyPassword(input);
    }
}
