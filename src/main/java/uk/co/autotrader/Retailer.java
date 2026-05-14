package uk.co.autotrader;

public class Retailer {
    private String retailerName;
    Listing listing;

    public Retailer(String retailerName){
        this.retailerName = retailerName;
    }

    public String getRetailerName() {
        return retailerName;
    }
}
