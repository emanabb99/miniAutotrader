package uk.co.autotrader;

import java.util.List;
import java.util.Random;

public class Listing {
    String vehicleName;
    Retailer owner;
    int price;
    Random random = new Random();
    String year;
    Categories category;

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
}
