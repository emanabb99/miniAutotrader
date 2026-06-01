package uk.co.autotrader;


import java.util.ArrayList;

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
