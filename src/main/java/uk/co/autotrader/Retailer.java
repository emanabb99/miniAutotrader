package uk.co.autotrader;

public class Retailer {
    private final String retailerName;
    private long id;

    public Retailer(String retailerName){
        this.retailerName = retailerName;
    }

    public String getRetailerName() {
        return retailerName;
    }

}
