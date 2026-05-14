package uk.co.autotrader;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ATSimulatorTest {

    @Test
    void givenSimulation_thenLinesAreOutput() {
        // Given
        ATSimulator simulator = new ATSimulator();

        // When
        List<String> output = simulator.outputSimulation();

        // Then
        assertEquals("Welcome to Mini Autotrader!", output.get(0));
    }

    @Test
    void simulationIndex1showsListing() {
        ATSimulator simulator = new ATSimulator();
        List<String> output = simulator.outputSimulation();
        assertEquals("Bob's and Belle's Bangers has listed a 1999 Ford Fiesta on Autotrader.",output.get(1));
    }
}
