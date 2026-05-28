package uk.co.autotrader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int day = 1;
        boolean weekFinished = false;
        Scanner sc = new Scanner(System.in);
        var simulator = new ATSimulator();
        while (!weekFinished) {
            simulator.outputSimulation(day);
            System.out.println("Press 'f' to finish day.");
            String finish = sc.nextLine();
            if (finish.equals("f")){
                day++;
                if (day == 4) {
                    weekFinished = true;
                }
            }
        }

    }
}