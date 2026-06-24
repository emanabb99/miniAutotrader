package uk.co.autotrader;

public enum Sort {
    PRICE_LOW_TO_HIGH(1),
    PRICE_HIGH_TO_LOW(2),
    AGE(3);
    final int number;
    Sort(int number){
        this.number = number;
    }
}
