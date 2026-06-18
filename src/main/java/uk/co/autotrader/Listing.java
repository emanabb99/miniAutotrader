package uk.co.autotrader;

import java.util.List;
import java.util.Random;

public class Listing {
    String vehicleName;
    private final Retailer owner;
    private int price;
    Random random = new Random();
    private final String year;
    private final Categories category;

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
        List<Integer> prices = List.of(1000,3000,6000,15000);
        price = prices.get(random.nextInt(4));
        return price;
    }

    public String createYear() {
        int year = random.nextInt(141)+1886;
        return String.valueOf(year);
    }

    public String getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public Categories generateRandomCategory() {
        Categories[] categoriesList = Categories.values();
        return categoriesList[random.nextInt(categoriesList.length)];
    }

    public String getDescription() {
        return vehicleName.concat(" (").concat(getYear()).concat(") - £").concat(String.valueOf(getPrice()).concat(" - ").concat(category.toString()));
    }
}
