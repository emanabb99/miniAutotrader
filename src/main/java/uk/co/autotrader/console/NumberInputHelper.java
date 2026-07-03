package uk.co.autotrader.console;

import java.util.Scanner;

public class NumberInputHelper {

    public static int handleIntegerInputs(Scanner scanner, int minNumber, int maxNumber) {
        int input;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
            input = scanner.nextInt();
            if (input >= minNumber && input <= maxNumber) {
                return input;
            }
            System.out.println("Please enter a number between " + minNumber + " and " + maxNumber);
        }
    }
}
