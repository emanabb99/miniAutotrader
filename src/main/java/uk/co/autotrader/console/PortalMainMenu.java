package uk.co.autotrader.console;

import uk.co.autotrader.model.Category;
import uk.co.autotrader.model.Listing;
import uk.co.autotrader.model.Retailer;
import uk.co.autotrader.service.Autotrader;
import uk.co.autotrader.service.DealerPortal;

import java.util.List;
import java.util.Scanner;

public class PortalMainMenu {
    Scanner sc = new Scanner(System.in);
    Autotrader autotrader;
    DealerPortal dealerPortal;
    Retailer retailer;

    public PortalMainMenu(Retailer retailer, Autotrader autotrader) {
        this.retailer = retailer;
        this.autotrader = autotrader;
        this.dealerPortal = new DealerPortal(retailer, autotrader);
    }

    public int welcomeRetailer() {
        System.out.println("Welcome " + retailer.getRetailerName() + " to Dealer Portal.");
        System.out.println("""
                Please choose one of the following options:
                1. Display all live listings
                2. Edit a listing
                3. Display all leads
                4. Log out
                """);
        return sc.nextInt();
    }

    public void displayListings() {
        List<Listing> listings = dealerPortal.displayListings();
        for (int i = 0; i < listings.size(); i++) {
            System.out.println(i + 1 + ". " + listings.get(i));
        }
    }

    public void displayLeads() {
        for (String leads : dealerPortal.displayLeads()) {
            System.out.println(leads);
        }
    }

    public Listing editListing() {
        System.out.println("Choose a listing to edit");
        Listing listingChosen = dealerPortal.displayListings().get(sc.nextInt() - 1);
        System.out.println("""
                Choose a feature to edit:
                1. Name
                2. Price
                3. Year
                4. Category
                """);
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 4) {
            for (Category category : Category.values()) {
                System.out.println(category);
            }
        }
        System.out.println("Enter new value: ");
        return dealerPortal.editListing(listingChosen, choice, sc.nextLine());
    }

    public void runMenu() {
        boolean loggedIn = true;
        int choice = welcomeRetailer();
        sc.nextLine();
        while (loggedIn) {
            switch (choice) {
                case (1):
                    displayListings();
                    break;
                case (2):
                    displayListings();
                    Listing updatedListing = editListing();
                    System.out.println("Updated Listing: \n" + updatedListing.getDescription());
                    break;
                case (3):
                    displayLeads();
                    break;
                case (4):
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Invalid option try again");
                    break;
            }
        }

    }

}
