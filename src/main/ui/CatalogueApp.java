package ui;

import model.Catalogue;
import model.Clothes;

import java.util.*;

public class CatalogueApp {
    private Scanner input = new Scanner(System.in);
    private Catalogue catalogue = new Catalogue();

    //EFFECTS: runs the catalogue application
    public CatalogueApp() {
        runCatalogue();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runCatalogue() {
        String command = null;

        while (true) {
            displayOptions();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                break;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\n You have quit the program, have a good day!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            // over you want to process more input for name, size, color, category, date
            // store all of them in variables
            // then call
            System.out.println("Item name: ");
            String itemName = input.next();

            System.out.println("Item size (number): ");
            int itemSize = input.nextInt();

            System.out.println("Item price: ");
            int itemPrice = input.nextInt();

            System.out.println("Item category: ");
            String itemCategory = input.next();

            catalogue.addClothes(itemName, itemSize, itemPrice, itemCategory);

            System.out.println("Item was successfully added!");

        } else if (command.equals("v")) {
            printCatalogue();
        } else if (command.equals("p")) {
            doSortByPrice();
        } else if (command.equals("s")) {
            doSortBySize();
        } else {
            System.out.println("This selection is not valid...");
        }
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: view all clothing in catalogue currently
    public void printCatalogue() {
        if (catalogue.getList().isEmpty()) {
            System.out.println("The catalogue is empty!");
        } else {
            for (Clothes item : catalogue.getList()) {
                System.out.println("name:" + item.getName() + " " + "size:" + item.getSize() + " "
                        + "$" + item.getPrice()
                        + " " + "category:" + item.getCategory());
            }
        }
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: sort clothing item in catalogue from lowest to highest price
    private void doSortByPrice() {
       catalogue.sortPrice();
        System.out.println("The catalogue has been sorted from lowest to highest price");
        printCatalogue();
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: sort clothing item in catalogue from smallest to largest size
    private void doSortBySize() {
        catalogue.sortSize();
        System.out.println("The catalogue has been sorted from smallest to largest size");
        printCatalogue();
    }

    // EFFECTS: displays menu of options to user
    private void displayOptions() {
        System.out.println("\n Welcome to Vintage Vault!");
        System.out.println("\n Select Option:");
        System.out.println("\ta -> add item");
        System.out.println("\tv -> view catalogue");
        System.out.println("\tp -> sort catalogue by price");
        System.out.println("\ts -> sort catalogue by size");
        System.out.println("\tq -> quit");

    }
}

