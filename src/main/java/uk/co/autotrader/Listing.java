package uk.co.autotrader;

import java.util.List;
import java.util.Random;

public class Listing {
    private String vehicleName;
    private final Retailer owner;
    private int price;
    private String year;
    private Category category;

    public Listing(String vehicleName, Retailer owner){
        this.vehicleName = vehicleName;
        this.owner = owner;
        this.price = createPrice();
        this.year = createYear();
        this.category = generateRandomCategory();
    }

    public Retailer getOwner() {
        return owner;
    }

    public int createPrice() {
        Random random = new Random();
        List<Integer> prices = List.of(1000,3000,6000,15000);
        return prices.get(random.nextInt(4));
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String createYear() {
        Random random = new Random();
        int year = random.nextInt(141)+1886;
        return String.valueOf(year);
    }

    public String getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public Category generateRandomCategory() {
        Random random = new Random();
        Category[] categoryList = Category.values();
        return categoryList[random.nextInt(categoryList.length)];
    }

    public Category getCategory(){
        return category;
    }

    public String getDescription() {
        return owner.getRetailerName() + "\n    " + vehicleName + "\n    " + getYear() + "\n    " + category + "\n    £" + getPrice() + "\n";
    }

    public String getVehicleName(){
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
