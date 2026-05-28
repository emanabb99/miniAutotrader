package uk.co.autotrader;

import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    public int menu() {
        System.out.println("Press number to access following menu options: ");
        System.out.println("""
                    1. Mini Autotrader
                    2. Add a new retailer
                    3. Add a new customer
                    4. View a retailer
                    5. View a customer
                    6. Skip ahead X days
                    7. Quit simulation
                    """);
        int choice =  sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public boolean displayMiniAutotrader(boolean weekFinished) {
        int day = 1;
        var simulator = new ATSimulator();
        while (!weekFinished) {
            List<String> output = simulator.outputSimulation(day);
            if (day < 4) {
                System.out.println("Press 'f' to finish day.");
                System.out.println("Press 'q' to quit");
            }
            else if (day < 5) {
                System.out.println("Press 'q' to quit");
            }
            String finish = sc.nextLine();
            switch (finish) {
                case ("f"):
                    day++;
                    output.clear();
                    if (day == 5) {
                        weekFinished = true;
                    }
                    break;
                case ("q"):
                    weekFinished = true;
                    break;
            }
        }
        return weekFinished;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        boolean simulation = true;
        boolean weekFinished = false;
        while (simulation) {
            int menuOption = main.menu();
            switch (menuOption) {
                case (1):
                    while (!weekFinished) {
                        weekFinished = main.displayMiniAutotrader(weekFinished);
                    }
                    break;
                case (2):
                    System.out.println("Enter retailer name");
                    Retailer retailer = new Retailer(sc.nextLine());
                    System.out.println("Retailer successfully added");
                    break;
                case (3):
                    System.out.println("Enter customer's full name");
                    Customer customer = new Customer(sc.nextLine());
                    System.out.println("Customer successfully added");
                    break;
                case (7):
                    simulation = false;
                    break;
            }

        }

    }
}