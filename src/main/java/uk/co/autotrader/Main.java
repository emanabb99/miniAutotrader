package uk.co.autotrader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    ATSimulator simulator = new ATSimulator();

    public int menu() {
        System.out.println("Press number to access following menu options: ");
        System.out.println("""
                    1. Continue
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

    public int displayMiniAutotrader() {
        int day = 1;
        int choice = 0;
        boolean weekFinished = false;
        while (!weekFinished) {
            List<String> output = simulator.outputSimulation(day);
            if (day < 4) {
                choice = menu();
            }
            switch (choice) {
                case (1):
                    day++;
                    output.clear();
                    if (day == 5) {
                        weekFinished = true;
                    }
                    break;
                default:
                    weekFinished = true;
                    return choice;
            }
        }
        return 0;
    }

    public void displayRetailers(String retailerName) {
        for (Retailer retailer: simulator.at.retailers) {
            if (retailerName.equals(retailer.getRetailerName())){
                System.out.println(retailer.getRetailerName());
            }
        }
    }

    public void displayCustomers(String customerName) {
        for (Customer customer: simulator.at.customers) {
            if (customerName.equals(customer.getCustomerName())){
                System.out.println(customer.getCustomerName());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        boolean simulation = true;
        while (simulation) {
            int choice = main.displayMiniAutotrader();
            switch (choice) {
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
                case (4):
                    System.out.println("Enter retailer name");
                    main.displayRetailers(sc.nextLine());
                case(5):
                    System.out.println("Enter customer full name");
                    main.displayCustomers(sc.nextLine());
                case (7):
                    simulation = false;
                    break;
            }

        }

    }
}