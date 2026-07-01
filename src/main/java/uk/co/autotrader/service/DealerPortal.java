package uk.co.autotrader.service;

import uk.co.autotrader.model.Category;
import uk.co.autotrader.model.Lead;
import uk.co.autotrader.model.Listing;
import uk.co.autotrader.model.Retailer;

import java.util.ArrayList;
import java.util.List;

public class DealerPortal {
    private final Retailer retailer;
    private final Autotrader autotrader;

    public DealerPortal(Retailer retailer, Autotrader autotrader) {
        this.retailer = retailer;
        this.autotrader = autotrader;
    }

    public void addListing(String vehicleName) {
        autotrader.addListing(new Listing(vehicleName, retailer));
    }

    public List<Listing> displayListings() {
        List<Listing> listingDescriptions = new ArrayList<>();
        for (Listing listing : autotrader.getCarsListedOnAutotrader()) {
            if (listing.getRetailer().equals(retailer)) {
                listingDescriptions.add(listing);
            }
        }
        return listingDescriptions;
    }

        public List<String> displayLeads () {
            List<String> leadsDescriptions = new ArrayList<>();
            for (Lead lead : autotrader.getLeads()) {
                if (lead.getRetailer().equals(retailer)) {
                    leadsDescriptions.add(lead.getMessage());
                }
            }
            return leadsDescriptions;
        }

        public Listing editListing (Listing listing,int choice, Object newValue){
            switch (choice) {
                case (1):
                    listing.setVehicleName(newValue.toString());
                    break;
                case (2):
                    listing.setPrice(Integer.parseInt(newValue.toString()));
                    break;
                case (3):
                    listing.setYear(newValue.toString());
                    break;
                case (4):
                    listing.setCategory(Category.valueOf(newValue.toString()));
                    break;
            }
            return listing;
        }

        public Autotrader getAutotrader () {
            return autotrader;
        }

    }
