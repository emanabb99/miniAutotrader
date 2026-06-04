package uk.co.autotrader;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ATSimulatorTest {
    ATSimulator simulator = new ATSimulator();
    List<String> output = new ArrayList<>();

    @Test
    void givenSimulationDay1_thenLinesAreOutput() {
        output = simulator.outputSimulation(1);
        assertEquals(18, output.size());
        assertEquals("********************** Day 1", output.get(0));
        assertEquals("Welcome to Mini Autotrader!", output.get(1));
        assertEquals("**********************", output.get(2));
        assertEquals("CAR LISTINGS:", output.get(3));
        assertEquals("Bob's and Belle's Bangers has listed a 1999 Ford Fiesta on Autotrader.", output.get(4));
        assertEquals("Big Buck's Best Deals has listed a Tesla Model Y on Autotrader.", output.get(5));
        assertEquals("Big Buck's Best Deals has listed a Fire Truck on Autotrader.", output.get(6));
        assertEquals("Ol' Granny Guardrails has listed a Robin Reliant on Autotrader.", output.get(7));
        assertEquals("**********************", output.get(8));
        assertEquals("CAR PURCHASES:", output.get(9));
        assertEquals("Megan Moneybanks has bought the car 1999 Ford Fiesta on Autotrader.", output.get(10));
        assertEquals("Robin Banks has bought the car Tesla Model Y on Autotrader.", output.get(11));
        assertEquals("Steve McSteve has bought the car Fire Truck on Autotrader.", output.get(12));
        assertEquals("**********************", output.get(13));
        assertEquals("There are 1 cars listed on Autotrader.", output.get(14));
        assertEquals("**********************", output.get(15));
        assertEquals("CAR LISTINGS:", output.get(16));
        assertEquals("Ol' Granny Guardrails has listed a Robin Reliant on Autotrader.", output.get(17));
    }

    @Test
    void givenSimulationDay2_thenLinesAreOutput() {
        output = (simulator.outputSimulation(1));
        output = (simulator.outputSimulation(2));
        assertEquals("********************** Day 2", output.get(18));
        assertEquals("Welcome to Mini Autotrader!", output.get(19));
        assertEquals("**********************", output.get(20));
        assertEquals("CAR LISTINGS:", output.get(21));
        assertEquals("Ol' Granny Guardrails has listed a Robin Reliant on Autotrader.", output.get(22));
        assertEquals("Eman's hot wheels has listed a Fiat 500 on Autotrader.", output.get(23));
        assertEquals("Another retailer has listed a Unknown car on Autotrader.", output.get(24));
        assertEquals("**********************", output.get(25));
        assertEquals("CAR PURCHASES:", output.get(26));
        assertEquals("Penny Coin has bought the car Robin Reliant on Autotrader.", output.get(27));
        assertEquals("**********************", output.get(28));
        assertEquals("There are 2 cars listed on Autotrader.", output.get(29));
        assertEquals("**********************", output.get(30));
        assertEquals("CAR LISTINGS:", output.get(31));
        assertEquals("Eman's hot wheels has listed a Fiat 500 on Autotrader.", output.get(32));
        assertEquals("Another retailer has listed a Unknown car on Autotrader.", output.get(33));
    }

    @Test
    void givenSimulationDay3_thenLinesAreOutput() {
        output = (simulator.outputSimulation(1));
        output = (simulator.outputSimulation(2));
        output = (simulator.outputSimulation(3));
        assertEquals("********************** Day 3", output.get(34));
        assertEquals("Welcome to Mini Autotrader!", output.get(35));
        assertEquals("**********************", output.get(36));
        assertEquals("CAR PURCHASES:", output.get(37));
        assertEquals("Peter Pan changed their mind about buying Fiat 500", output.get(38));
        assertEquals("**********************", output.get(39));
        assertEquals("There are 3 cars listed on Autotrader.", output.get(40));
        assertEquals("**********************", output.get(41));
        assertEquals("CAR LISTINGS:", output.get(42));
        assertEquals("Eman's hot wheels has listed a Fiat 500 on Autotrader.", output.get(43));
        assertEquals("Another retailer has listed a Unknown car on Autotrader.", output.get(44));
        assertEquals("Last retailer has listed a Bus on Autotrader.", output.get(45));
    }

    @Test
    void givenSimulationSummary_thenLinesAreOutput() {
        output = (simulator.outputSimulation(1));
        output = (simulator.outputSimulation(2));
        output = (simulator.outputSimulation(3));
        output = (simulator.outputSimulation(4));
        assertEquals("**********************", output.get(46));
        assertEquals("Performance for last 3 days", output.get(47));
        assertEquals("Total sold cars: 4", output.get(48));
        assertEquals("**********************", output.get(49));
        assertEquals("CAR LISTINGS:", output.get(50));
        assertEquals("Eman's hot wheels has listed a Fiat 500 on Autotrader.", output.get(51));
        assertEquals("Another retailer has listed a Unknown car on Autotrader.", output.get(52));
        assertEquals("Last retailer has listed a Bus on Autotrader.", output.get(53));

    }
}
