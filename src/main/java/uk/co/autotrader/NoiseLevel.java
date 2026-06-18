package uk.co.autotrader;

public enum NoiseLevel {
    QUIET(1),
    NORMAL(2),
    VERBOSE(3);

    private final int value;

    NoiseLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
