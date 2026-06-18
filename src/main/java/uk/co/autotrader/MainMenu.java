package uk.co.autotrader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    Scanner sc = new Scanner(System.in);
    ATSimulator simulator = new ATSimulator();

    public NoiseLevel chooseNoiseLevel() {
        System.out.println("Type in number for your desired noise level: ");
        for (NoiseLevel noiseLevel : NoiseLevel.values()) {
            System.out.println(noiseLevel.getValue() + ". " + noiseLevel);
        }
        int choice = sc.nextInt();
        sc.nextLine();
        for (NoiseLevel noiseLevel : NoiseLevel.values()) {
            if (noiseLevel.getValue() == choice) {
                return noiseLevel;
            }
        }
        return null;
    }

    public int displayMenu() {
        System.out.println("Enter number to access following Menu options: ");
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

    public void displayMiniAutotrader(int day, NoiseLevel noiseLevel) {
        if (day < 5) {
            List<String> output = simulator.outputSimulation(day, noiseLevel);
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

    public boolean findCustomer(String customerName) {
        boolean customerFound = false;
        for (Customer customer : simulator.at.customers) {
            if (customerName.equals(customer.getCustomerName())) {
                customerFound = true;
                break;
            }
        }
        return customerFound;
    }

    public void addRetailer(Retailer retailer) {
        simulator.at.addRetailer(retailer);
    }

    public void runMenuAndMiniAutoTrader() {
        int day = 1;
        NoiseLevel noiseLevel = chooseNoiseLevel();
        while (noiseLevel==null) {
            System.out.println("Invalid choice - please try again.");
            noiseLevel = chooseNoiseLevel();
        }
        boolean simulation = true;
        while (simulation) {
            displayMiniAutotrader(day, noiseLevel);
            int choice = displayMenu();
            switch (choice) {
                case (1):
                    day++;
                    break;
                case (2):
                    day++;
                    System.out.println("Enter retailer name");
                    Retailer retailer = new Retailer(sc.nextLine());
                    addRetailer(retailer);
                    System.out.println("Retailer successfully added");
                    break;
                case (3):
                    day++;
                    System.out.println("Enter customer's full name");
                    new Customer(sc.nextLine());
                    System.out.println("Customer successfully added");
                    break;
                case (4):
                    day++;
                    System.out.println("Enter retailer name");
                    String retailerName = sc.nextLine();
                    if (!findRetailer(retailerName)) {
                        System.out.println("Retailer not found");
                    } else {
                        List<Listing> retailerListings = displayListings(retailerName);
                        if (retailerListings.isEmpty()) {
                            System.out.println("No retailer listings");
                        } else {
                            for (Listing listing : retailerListings) {
                                System.out.println(listing.getDescription());
                            }
                        }
                    }
                    break;
                case (5):
                    day++;
                    System.out.println("Enter customer full name");
                    boolean customerFound = findCustomer(sc.nextLine());
                    if (customerFound) {
                        System.out.println(customerFound);
                    } else {
                        System.out.println("Customer not found");
                    }
                    break;
                case (6):
                    System.out.println("What day would you like to go to? Choose upto day 3.");
                    day = sc.nextInt();
                    sc.nextLine();
                    break;
                case (7):
                    simulation = false;
                    break;
            }
        }
    }

    static void main() {
        MainMenu main = new MainMenu();
        main.runMenuAndMiniAutoTrader();
    }
}