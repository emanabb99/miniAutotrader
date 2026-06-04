package uk.co.autotrader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    Scanner sc = new Scanner(System.in);
    ATSimulator simulator = new ATSimulator();

    public int displayMenu() {
        System.out.println("Press number to access following displayMenu options: ");
        System.out.println("""
                1. Continue
                2. Add a new retailer
                3. Add a new customer
                4. View a retailer
                5. View a customer
                6. Skip ahead X days
                7. Quit simulation
                """);
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public void displayMiniAutotrader(int day) {
        if (day < 5) {
            List<String> output = simulator.outputSimulation(day);
            output.clear();
        }
    }

    public boolean findRetailer(String retailerName) {
        boolean retailerFound = false;
        for (Retailer retailer : simulator.at.retailers) {
            if (retailerName.equals(retailer.getRetailerName())) {
                retailerFound = true;
                break;
            }
        }
        return retailerFound;
    }

    public List<Listing> displayListings(String retailerName) {
        List<Listing> allListings = new ArrayList<>();
        for (Listing listing : simulator.at.carsListedOnAutotrader) {
            if (listing.getOwner().getRetailerName().equals(retailerName)) {
                allListings.add(listing);
            }
        }
        return allListings;
    }

    public void displayCustomers(String customerName) {
        for (Customer customer : simulator.at.customers) {
            if (customerName.equals(customer.getCustomerName())) {
                System.out.println(customer.getCustomerName());
            }
        }
    }

    public void addRetailer(Retailer retailer) {
        simulator.at.addRetailer(retailer);
    }

    static void main() {
        int day = 1;
        MainMenu main = new MainMenu();
        boolean simulation = true;
        while (simulation) {
            main.displayMiniAutotrader(day);
            int choice = main.displayMenu();
            switch (choice) {
                case (1):
                    day++;
                    break;
                case (2):
                    System.out.println("Enter retailer name");
                    Retailer retailer = new Retailer(main.sc.nextLine());
                    main.addRetailer(retailer);
                    System.out.println("Retailer successfully added");
                    break;
                case (3):
                    System.out.println("Enter customer's full name");
                    new Customer(main.sc.nextLine());
                    System.out.println("Customer successfully added");
                    break;
                case (4):
                    System.out.println("Enter retailer name");
                    String retailerName = main.sc.nextLine();
                    if (!main.findRetailer(retailerName)) {
                        System.out.println("Retailer not found");
                    } else {
                        List<Listing> listings = main.displayListings(retailerName);
                        if (listings.isEmpty()) {
                            System.out.println("No listings");
                        } else {
                            for (Listing listing : listings) {
                                System.out.println(listing.vehicle);
                            }
                        }
                    }
                    break;
                case (5):
                    System.out.println("Enter customer full name");
                    main.displayCustomers(main.sc.nextLine());
                    break;
                case (6):
                    System.out.println("What day would you like to go to? Choose upto day 3.");
                    day = main.sc.nextInt();
                    main.sc.nextLine();
                    break;
                case (7):
                    simulation = false;
                    break;
            }
        }
    }
}