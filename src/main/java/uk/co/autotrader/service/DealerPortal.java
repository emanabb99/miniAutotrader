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

    public List<String> displayLeads() {
        List<String> leadsDescriptions = new ArrayList<>();
        for (Lead lead : autotrader.getLeads()) {
            if (lead.getRetailer().getRetailerName().equals(retailer.getRetailerName())) {
                leadsDescriptions.add(lead.getMessage());
            }
        }
        return leadsDescriptions;
    }

    public Listing editListing(Listing listing, int choice, String newValue) {
        switch (choice) {
            case (1):
                editListingName(listing,newValue);
                break;
            case (2):
                editListingPrice(listing,Integer.parseInt(newValue));
                break;
            case (3):
                editListingYear(listing,newValue);
                break;
            case (4):
                editListingCategory(listing,newValue);
                break;
        }
        return listing;
    }

    public void editListingName(Listing listing, String name) {
        listing.setVehicleName(name);
    }

    public void editListingPrice(Listing listing, int price){
        listing.setPrice(price);
    }

    public void editListingYear(Listing listing, String year) {
        listing.setYear(year);
    }

    public void editListingCategory(Listing listing, String category){
        listing.setCategory(Category.valueOf(category));
    }

    public Autotrader getAutotrader() {
        return autotrader;
    }

}
