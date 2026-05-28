package uk.co.autotrader;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ATSimulatorTest {
    ATSimulator simulator = new ATSimulator();
    List <String> output = new ArrayList<>();

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
        assertEquals("********************** Day 2",output.get(18));
        assertEquals("Welcome to Mini Autotrader!",output.get(19));
        assertEquals("**********************",output.get(20));
        assertEquals("CAR LISTINGS:",output.get(21));
        assertEquals("Ol' Granny Guardrails has listed a Robin Reliant on Autotrader.",output.get(22));
        assertEquals("Eman's hot wheels has listed a Fiat 500 on Autotrader.",output.get(23));
        assertEquals("I cant think of another name has listed a Unknown car on Autotrader.",output.get(24));
        assertEquals("**********************",output.get(25));
        assertEquals("CAR PURCHASES:",output.get(26));
        assertEquals("Penny Coin has bought the car Fiat 500 on Autotrader.",output.get(27));
        assertEquals("Johny Bravo has bought the car Robin Reliant on Autotrader.",output.get(28));
    }
}
