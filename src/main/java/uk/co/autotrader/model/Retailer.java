package uk.co.autotrader.model;

public class Retailer {
    private final String retailerName;
    private String email = "";
    private String password = "";

    public Retailer(String retailerName, String email, String password){
        this.retailerName = retailerName;
        this.email = email;
        this.password = password;
    }

    public Retailer(String retailerName) {
        this.retailerName = retailerName;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public String getEmail() { return email; }

    public boolean verifyPassword(String input) {
        return input.equals(password);
    }
}
