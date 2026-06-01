package uk.co.autotrader;

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

    public void displayMiniAutotrader(int day) {
        if (day<5) {
            List<String> output = simulator.outputSimulation(day);
            output.clear();
        }
    }

    public void displayRetailers(String retailerName) {
        for (Retailer retailer: simulator.at.retailers) {
            if (retailerName.equals(retailer.getRetailerName())){
                System.out.println(retailer.getRetailerName());
            }
        }
        for (Listing listing: simulator.at.carsListedOnAutotrader){
            if (retailerName.equals(listing.getOwner().getRetailerName())) {
                System.out.println(listing.vehicle);
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
        int day = 1;
        Main main = new Main();
        boolean simulation = true;
        while (simulation) {
            main.displayMiniAutotrader(day);
            int choice = main.menu();
            switch (choice) {
                case (1):
                    day++;
                    break;
                case (2):
                    System.out.println("Enter retailer name");
                    Retailer retailer = new Retailer(main.sc.nextLine());
                    System.out.println("Retailer successfully added");
                    break;
                case (3):
                    System.out.println("Enter customer's full name");
                    Customer customer = new Customer(main.sc.nextLine());
                    System.out.println("Customer successfully added");
                    break;
                case (4):
                    System.out.println("Enter retailer name");
                    main.displayRetailers(main.sc.nextLine());
                    break;
                case (5):
                    System.out.println("Enter customer full name");
                    main.displayCustomers(main.sc.nextLine());
                    break;
                case (6):
                    System.out.println("What day would you like to go to? Choose upto day 3.");
                    int dayForward = main.sc.nextInt();
                    main.sc.nextLine();
                    main.displayMiniAutotrader(dayForward);
                    break;
                case (7):
                    simulation = false;
                    break;
            }
        }
    }
}