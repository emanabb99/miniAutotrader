package uk.co.autotrader.model;

public enum Sort {
    PRICE_LOW_TO_HIGH(1),
    PRICE_HIGH_TO_LOW(2),
    AGE(3);
    private final int number;
    Sort(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
