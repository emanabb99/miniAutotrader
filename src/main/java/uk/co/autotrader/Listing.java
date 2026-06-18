package uk.co.autotrader;

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
        this.price = createPrice();
        this.year = createYear();
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
        int firstDigit = random.nextInt(2)+1;
        int secondDigit = firstDigit==1 ? random.nextInt(2)+8 : 0;
        int thirdDigit = switch (secondDigit) {
            case (8) -> random.nextInt(2) + 8;
            case (0) -> random.nextInt(3);
            default -> random.nextInt(10);
        };
        int fourthDigit = switch (thirdDigit) {
            case(8) -> random.nextInt(4)+6;
            case(2) -> random.nextInt(7);
            default -> random.nextInt(10);
        };
        return String.valueOf(firstDigit).concat(String.valueOf(secondDigit)).concat(String.valueOf(thirdDigit)).concat(String.valueOf(fourthDigit));
    }

    public String getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }
}
