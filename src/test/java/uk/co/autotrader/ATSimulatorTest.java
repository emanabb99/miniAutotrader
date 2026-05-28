package uk.co.autotrader;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ATSimulatorTest {

    @Test
    void givenSimulationDay1_thenLinesAreOutput() {
        // Given
        ATSimulator simulator = new ATSimulator();

        // When
        List<String> output = simulator.outputSimulation(1);

        // Then
        assertEquals(18, output.size());
        assertEquals("********************** Day 1", output.get(0));
        assertEquals("Welcome to Mini Autotrader!", output.get(1));
        assertEquals("**********************", output.get(2));
        assertEquals("CAR LISTINGS:", output.get(3));
        assertEquals("Bob's and Belle's Bangers has listed a 1999 Ford Fiesta on Autotrader.", output.get(4));
        assertEquals("Big Buck’s Best Deals has listed a Tesla Model Y on Autotrader.", output.get(5));
        assertEquals("Big Buck’s Best Deals has listed a Fire Truck on Autotrader.", output.get(6));
        assertEquals("Ol’ Granny Guardrails has listed a Robin Reliant on Autotrader.", output.get(7));
        assertEquals("**********************", output.get(8));
        assertEquals("CAR PURCHASES:", output.get(9));
        assertEquals("Megan Moneybanks has bought the car 1999 Ford Fiesta on Autotrader.", output.get(10));
        assertEquals("Robin Banks has bought the car Tesla Model Y on Autotrader.", output.get(11));
        assertEquals("Steve McSteve has bought the car Fire Truck on Autotrader.", output.get(12));
        assertEquals("**********************", output.get(13));
        assertEquals("There are 1 cars listed on Autotrader.", output.get(14));
        assertEquals("**********************", output.get(15));
        assertEquals("CAR LISTINGS:", output.get(16));
        assertEquals("Ol’ Granny Guardrails has listed a Robin Reliant on Autotrader.", output.get(17));
    }

    @Test
    void givenSimulationDay2_thenLinesAreOutput() {
        ATSimulator simulator = new ATSimulator();
        List<String> output = simulator.outputSimulation(2);
        assertEquals(2,output.size());
        assertEquals("********************** Day 2",output.get(0));
        assertEquals("Welcome to Mini Autotrader!",output.get(1));
    }
}
