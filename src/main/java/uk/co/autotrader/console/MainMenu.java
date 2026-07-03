package uk.co.autotrader.console;

import uk.co.autotrader.model.*;
import uk.co.autotrader.service.Authentication;
import uk.co.autotrader.service.Autotrader;
import uk.co.autotrader.simulation.ATSimulator;

import java.util.*;

public class MainMenu {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> output = new ArrayList<>();
    Autotrader autotrader = new Autotrader();
    ATSimulator simulator = new ATSimulator(autotrader, output);

    public Sort sortResults(int sortNumber) {
        return switch (sortNumber) {
            case (1) -> Sort.PRICE_LOW_TO_HIGH;
            case (2) -> Sort.PRICE_HIGH_TO_LOW;
            case (3) -> Sort.AGE;
            default -> Sort.DEFAULT;
        };
    }

    public NoiseLevel chooseNoiseLevel() {
        System.out.println("Type in number for your desired noise level: ");
        for (NoiseLevel noiseLevel : NoiseLevel.values()) {
            System.out.println(noiseLevel.getValue() + ". " + noiseLevel);
        }
        int choice = NumberInputHelper.handleIntegerInputs(sc, 1, 3);
        for (NoiseLevel noiseLevel : NoiseLevel.values()) {
            if (noiseLevel.getValue() == choice) {
                return noiseLevel;
            }
        }
        throw new IllegalStateException("Invalid noise level");
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
                7. Sort listings
                8. Quit simulation
                9. Sign into Dealer Portal
                """);
        return NumberInputHelper.handleIntegerInputs(sc,1,9);
    }

    public void displayMiniAutotrader(int day, NoiseLevel noiseLevel, boolean summary, Sort filter) {
        List<String> output = simulator.outputSimulation(day, noiseLevel, summary, filter);
        output.clear();
    }

    public List<Listing> displayListings(Retailer retailer) {
        List<Listing> allListings = new ArrayList<>();
        for (Listing listing : autotrader.getCarsListedOnAutotrader()) {
            if (listing.getRetailer().equals(retailer)) {
                allListings.add(listing);
            }
        }
        return allListings;
    }

    public void addCustomer(Customer customer) {
        autotrader.addCustomer(customer);
        if (autotrader.getCustomers().contains(customer)) {
            System.out.println("Customer successfully added");
        }
    }

    public void addRetailer(Retailer retailer) {
        autotrader.addRetailer(retailer);
        if (autotrader.getRetailers().contains(retailer)) {
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
        Optional<Retailer> retailer = autotrader.findRetailerByName(sc.nextLine());
        if (retailer.isEmpty()) {
            System.out.println("Retailer not found");
        }
        else {
            List<Listing> retailerListings = displayListings(retailer.get());
            if (retailerListings.isEmpty()) System.out.println("No retailer listings");
            else {
                retailerListings.forEach(list -> System.out.println(list.getDescription()));
            }
        }
    }

    public void handleFindCustomer() {
        System.out.println("Enter customer full name");
        Customer customer = autotrader.findCustomerByName(sc.nextLine());
        if (customer != null) {
            System.out.println("Customer found - " + customer.getCustomerName());
        } else {
            System.out.println("Customer not found");
        }
    }

    public Sort handleSorting() {
        System.out.println("Choose how to sort the results");
        for (Sort sorted : Sort.values()) {
            System.out.println(sorted.getNumber() + ". " + sorted);
        }
        int sortNumber = NumberInputHelper.handleIntegerInputs(sc,1,4);
        return sortResults(sortNumber);
    }

    public void runMenuAndMiniAutoTrader() {
        int day = 1;
        Sort sort = Sort.DEFAULT;
        NoiseLevel noiseLevel = chooseNoiseLevel();
        boolean simulation = true;
        boolean summary = false;
        displayMiniAutotrader(day, noiseLevel, summary, sort);
        while (simulation) {
            int choice = displayMenu();
            switch (choice) {
                case (1):
                    day++;
                    displayMiniAutotrader(day, noiseLevel, summary, sort);
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
                    day = NumberInputHelper.handleIntegerInputs(sc,1);
                    displayMiniAutotrader(day, noiseLevel, summary, sort);
                    break;
                case (7):
                    sort = handleSorting();
                    day++;
                    displayMiniAutotrader(day, noiseLevel, summary, sort);
                    break;
                case (8):
                    simulation = false;
                    summary = true;
                    break;
                case (9):
                    handleLogin();
                    break;
                default:
                    System.out.println("Invalid choice - please try again.");
                    break;
            }
        }
        displayMiniAutotrader(day, noiseLevel, summary, sort);
    }

    public Optional<Retailer> checkCredentials(String email, String password) {
        Authentication authentication = new Authentication(autotrader);
        Optional<Retailer> retailer = authentication.findRetailerByEmail(email);
        if (retailer.isEmpty()){
            return Optional.empty();
        }
        else {
            return authentication.verifyRetailerPassword(password,retailer.get()) ? retailer : Optional.empty();
        }
    }

    public void handleLogin() {
        boolean loggingIn = true;
        while (loggingIn) {
            System.out.println("Enter portal email address");
            String email = sc.nextLine();
            System.out.println("Enter password");
            String password = sc.nextLine();
            Optional<Retailer> retailerFound = checkCredentials(email, password);
            if (retailerFound.isEmpty()) {
                System.out.println("Invalid login details. Press any letter to try again. Press 'Q' to quit.");
                if (sc.nextLine().equalsIgnoreCase("Q")) {
                    loggingIn = false;
                }
            }
            else {
                transferToPortal(retailerFound.get());
                loggingIn = false;
            }
        }

    }

    public void transferToPortal(Retailer retailer) {
        PortalMainMenu portalMainMenu = new PortalMainMenu(retailer, autotrader);
        portalMainMenu.runMenu();
    }

    static void main() {
        MainMenu main = new MainMenu();
        main.runMenuAndMiniAutoTrader();
    }
}