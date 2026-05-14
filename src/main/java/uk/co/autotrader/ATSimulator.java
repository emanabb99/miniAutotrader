package uk.co.autotrader;

import java.util.ArrayList;
import java.util.List;

public class ATSimulator {

    private final ArrayList<String> output = new ArrayList<>();

    public List<String> outputSimulation() {
        runSimulation();

        for (String line: output) {
            System.out.println(line);
        }

        return output;
    }

    private void runSimulation() {
        output.add("Welcome to Mini Autotrader!");
        String retailerName = "Bob's and Belle's Bangers";
        String carName = "1999 Ford Fiesta";
        String carBuyerName = "Megan MoneyBanks";
        ArrayList<String> carsListedOnAutotrader = new ArrayList<>();
        carsListedOnAutotrader.add(carName);
        output.add(retailerName + " has listed a " + carName + " on Autotrader.");
    }
}
