package uk.co.autotrader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    Scanner sc = new Scanner(System.in);
    ATSimulator simulator = new ATSimulator();

    public Sort sortResults(int sortNumber) {
        return switch(sortNumber) {
            case (1) -> Sort.PRICE_LOW_TO_HIGH;
            case (2) -> Sort.PRICE_HIGH_TO_LOW;
            case (3) -> Sort.AGE;
            default -> null;
        };
    }

    public NoiseLevel chooseNoiseLevel() {
        NoiseLevel noiseLevelchoice = null;
        System.out.println("Type in number for your desired noise level: ");
        for (NoiseLevel noiseLevel : NoiseLevel.values()) {
            System.out.println(noiseLevel.getValue() + ". " + noiseLevel);
        }
        int choice = sc.nextInt();
        sc.nextLine();
        for (NoiseLevel noiseLevel : NoiseLevel.values()) {
            if (noiseLevel.getValue() == choice) {
                noiseLevelchoice = noiseLevel;
            }
        }
        while (noiseLevelchoice==null) {
            System.out.println("Invalid choice - please try again");
            noiseLevelchoice = chooseNoiseLevel();
        }
        return noiseLevelchoice;
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
                7. Filter the results
                8. Quit simulation
                """);
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public void displayMiniAutotrader(int day, NoiseLevel noiseLevel, boolean summary, Sort filter) {
        List<String> output = simulator.outputSimulation(day, noiseLevel, summary, filter);
        output.clear();
    }

    public Retailer findRetailer(String retailerName) {
        for (Retailer retailer : simulator.at.getRetailers()) {
            if (retailerName.equals(retailer.getRetailerName())) {
                return retailer;
            }
        }
        return null;
    }

    public List<Listing> displayListings(Retailer retailer) {
        List<Listing> allListings = new ArrayList<>();
        for (Listing listing : simulator.at.getCarsListedOnAutotrader()) {
            if (listing.getOwner().equals(retailer)) {
                allListings.add(listing);
            }
        }
        return allListings;
    }

    public Customer findCustomer(String customerName) {
        for (Customer customer : simulator.at.getCustomers()) {
            if (customerName.equals(customer.getCustomerName())) {
                return customer;
            }
        }
        return null;
    }

    public void addCustomer(Customer customer) {
        simulator.at.addCustomer(customer);
        if (simulator.at.getCustomers().contains(customer)) {
            System.out.println("Customer successfully added");
        }
    }

    public void addRetailer(Retailer retailer) {
        simulator.at.addRetailer(retailer);
        if (simulator.at.getRetailers().contains(retailer)) {
            System.out.println("Retailer successfully added");
        }
    }

    public Retailer handleAddRetailer() {
        System.out.println("Enter retailer name");
        return new Retailer(sc.nextLine());
    }

    public Customer handleAddCustomer() {
        System.out.println("Enter customer's full name");
        return new Customer(sc.nextLine());
    }

    public void handleFindRetailer() {
        System.out.println("Enter retailer name");
        Retailer retailer = findRetailer(sc.nextLine());
        if (retailer==null) {
            System.out.println("Retailer not found");
        } else {
            List<Listing> retailerListings = displayListings(retailer);
            if (retailerListings.isEmpty()) {
                System.out.println("No retailer listings");
            } else {
                retailerListings.forEach(list-> System.out.println(list.getDescription()));
            }
        }
    }

    public void handleFindCustomer() {
        System.out.println("Enter customer full name");
        Customer customer = findCustomer(sc.nextLine());
        if (customer!=null) {
            System.out.println("Customer found - " + customer.getCustomerName());
        } else {
            System.out.println("Customer not found");
        }
    }

    public Sort handleSorting() {
        System.out.println("Choose how to filter the results");
        for (Sort sorted: Sort.values()) {
            System.out.println(sorted.getNumber() + ". " + sorted);
        }
        int sortNumber = sc.nextInt();
        sc.nextLine();
        return sortResults(sortNumber);
    }

    public void runMenuAndMiniAutoTrader() {
        int day = 1;
        Sort sort = null;
        NoiseLevel noiseLevel = chooseNoiseLevel();
        boolean simulation = true;
        boolean summary = false;
        while (simulation) {
            displayMiniAutotrader(day, noiseLevel, summary, sort);
            int choice = displayMenu();
            switch (choice) {
                case (1):
                    day++;
                    break;
                case (2):
                    addRetailer(handleAddRetailer());
                    break;
                case (3):
                    addCustomer(handleAddCustomer());
                    break;
                case (4):
                    handleFindRetailer();
                    break;
                case (5):
                    handleFindCustomer();
                    break;
                case (6):
                    System.out.println("What day would you like to go to?");
                    day = sc.nextInt();
                    sc.nextLine();
                    break;
                case (7):
                    sort = handleSorting();
                    break;
                case (8):
                    simulation = false;
                    summary = true;
                    break;
                default:
                    System.out.println("Invalid choice - please try again.");
                    break;
            }
        }
        displayMiniAutotrader(day,noiseLevel,summary,sort);
    }

    static void main() {
        MainMenu main = new MainMenu();
        main.runMenuAndMiniAutoTrader();
    }
}