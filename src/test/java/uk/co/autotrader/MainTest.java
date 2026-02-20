package uk.co.autotrader;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void givenMain_andNoCommandLineArguments_whenRun_thenNoError() {
        Main.main(new String[]{});
    }
}