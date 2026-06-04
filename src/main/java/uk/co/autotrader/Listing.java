package uk.co.autotrader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Listing {
    String vehicleName;
    Retailer owner;
    int price;
    Random random = new Random();
    String year;

    public Listing(String vehicleName, Retailer owner){
        this.vehicleName = vehicleName;
        this.owner = owner;

        List<Integer> prices = List.of(1000,3000,6000,15000);
        price = prices.get(random.nextInt(4));

        year = String.valueOf(random.nextInt(3)+1);

        int[] secondDigit = {0,8,9};
        year = year.concat(String.valueOf(secondDigit[random.nextInt(3)]));



    }

    public Retailer getOwner() {
        return owner;
    }
}
