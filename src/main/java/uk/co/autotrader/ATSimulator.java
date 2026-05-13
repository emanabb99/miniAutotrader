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
    }
}
