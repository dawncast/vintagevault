package ui;

import model.Catalogue;
import model.Clothes;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//represents a catalogue app that users can interact with
public class CatalogueApp extends JFrame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private static final String JSON_STORE = "./data/catalogue.json";
    private Scanner input = new Scanner(System.in);
    private Catalogue catalogue = new Catalogue();
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JFrame frame;

    //EFFECTS: runs the catalogue application
    public CatalogueApp() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        //runCatalogue();
        catalogueUI();
    }

    // EFFECTS: constructs the catalogue GUI
    public void catalogueUI() {
        frame = new JFrame(); //creates a frame
        frame.setSize(WIDTH, HEIGHT); //sets x and y dimension of frame
        frame.setTitle("Catalogue App"); //sets title for frame
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        frame.setVisible(true); //make frame visible

        frame.getContentPane().setBackground(new Color(229, 204, 255)); // change color of background


        menuButton();


    }

    @SuppressWarnings("methodlength")
    private void menuButton() {
        JButton addButton = new JButton("add clothing item");
        addButton.setBounds(450, 100, 200, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addActionFrame = new JFrame();
                addActionFrame.setVisible(true);
                addActionFrame.setSize(400, 300);
                addActionFrame.setResizable(false);

                JPanel panel = new JPanel();
                addActionFrame.add(panel);

                JLabel nameLabel = new JLabel("clothing name: ");
                nameLabel.setBounds(10, 20, 80, 25);
                panel.add(nameLabel);

                JTextField nameText = new JTextField(20);
                nameText.setBounds(100, 20, 165, 25);
                panel.add(nameText);

                JLabel sizeLabel = new JLabel("clothing size: ");
                sizeLabel.setBounds(10, 20, 80, 25);
                panel.add(sizeLabel);

                JTextField sizeText = new JTextField(20);
                sizeText.setBounds(100, 20, 165, 25);
                panel.add(sizeText);

                JLabel priceLabel = new JLabel("clothing price: ");
                priceLabel.setBounds(10, 20, 80, 25);
                panel.add(priceLabel);

                JTextField priceText = new JTextField(20);
                priceText.setBounds(100, 20, 165, 25);
                panel.add(priceText);

                JLabel categoryLabel = new JLabel("clothing category: ");
                categoryLabel.setBounds(10, 20, 80, 25);
                panel.add(categoryLabel);

                JTextField cateText = new JTextField(20);
                cateText.setBounds(100, 20, 165, 25);
                panel.add(cateText);

                JButton doneButton = new JButton();
                doneButton.setBounds(10, 80, 80, 25);
                doneButton.setText("done");
                panel.add(doneButton);
                doneButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String itemName = nameText.getText();
                        int itemSize = Integer.parseInt(sizeText.getText());
                        int itemPrice = Integer.parseInt(priceText.getText());
                        String itemCategory = cateText.getText();

                        catalogue.addClothItem(itemName, itemSize, itemPrice, itemCategory);
//                        JLabel doneMessage = new JLabel("successfully added!");
//                        doneMessage.setBounds(10, 20, 80, 25);
//                        panel.add(doneMessage);

                    }
                });


            }
        });


        JButton removeButton = new JButton("remove clothing item");
        removeButton.setBounds(450, 150, 200, 30);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame removeActionFrame = new JFrame();
                removeActionFrame.setVisible(true);
                removeActionFrame.setSize(400, 300);
                removeActionFrame.setResizable(false);
                removeActionFrame.setVisible(true);

                JPanel panel = new JPanel();
                removeActionFrame.add(panel);

                JLabel nameLabel = new JLabel("clothing name: ");
                nameLabel.setBounds(10, 20, 80, 25);
                panel.add(nameLabel);

                JTextField nameText = new JTextField(20);
                nameText.setBounds(100, 20, 165, 25);
                panel.add(nameText);

                JButton doneButton = new JButton();
                doneButton.setBounds(10, 80, 80, 25);
                doneButton.setText("done");
                panel.add(doneButton);
                doneButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String itemName = nameText.getText();
                        catalogue.removeClothes(itemName);

                    }
                });
            }
        });


        JButton viewButton = new JButton("view catalogue");
        viewButton.setBounds(450, 200, 200, 30);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame viewActionFrame = new JFrame();
                JPanel panel = new JPanel();
                viewActionFrame.add(panel);
                viewActionFrame.setVisible(true);
                viewActionFrame.setSize(400, 300);
                viewActionFrame.setResizable(true);
                if (catalogue.getList().isEmpty()) {
                    JLabel emptyMessage = new JLabel("The catalogue is empty!");
                    emptyMessage.setBounds(10, 20, 80, 25);
                    panel.add(emptyMessage);

                } else {
                    for (Clothes item : catalogue.getList()) {
                        JLabel printCatalogue = new JLabel("name:" + item.getName() + " "
                                + "size:" + item.getSize() + " "
                                + "$" + item.getPrice()
                                + " " + "category:" + item.getCategory());
                        printCatalogue.setBounds(10, 20, 80, 25);
                        panel.add(printCatalogue);
                    }

                }
                JButton sortButton = new JButton();
                sortButton.setBounds(10, 100, 80, 25);
                sortButton.setText("sort");
                panel.add(sortButton);
                sortButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //todo
                        catalogue.sortPrice();

                    }
                });
            }
        });


//        JButton priceButton = new JButton("sort catalogue by price");
//        priceButton.setBounds(450, 250, 200, 30);
//        priceButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFrame sortActionFrame = new JFrame();
//                sortActionFrame.setVisible(true);
//                sortActionFrame.setSize(400, 300);
//                sortActionFrame.setResizable(true);
//            }
//        });


        JButton saveButton = new JButton("save catalogue");
        saveButton.setBounds(450, 300, 200, 30);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveWorkRoom();
            }
        });


        JButton loadButton = new JButton("load catalogue");
        loadButton.setBounds(450, 350, 200, 30);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadWorkRoom();
            }
        });


        frame.add(addButton);
        frame.add(removeButton);
        frame.add(viewButton);
        //frame.add(priceButton);
        frame.add(saveButton);
        frame.add(loadButton);


    }

    // EFFECTS: saves the workroom to file
    private void saveWorkRoom() {
        try {
            jsonWriter.open();
            jsonWriter.write(catalogue);
            jsonWriter.close();
            System.out.println("Saved " + "catalogue" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }


    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadWorkRoom() {
        try {
            catalogue = jsonReader.read();
            System.out.println("Loaded " + "catalogue" + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}


//    // MODIFIES: this
//    // EFFECTS: processes user input
//    private void runCatalogue() {
//        String command = null;
//
//        while (true) {
//            displayOptions();
//            command = input.next();
//            command = command.toLowerCase();
//
//            if (command.equals("q")) {
//                break;
//            } else {
//                processCommand(command);
//            }
//        }
//        System.out.println("\n You have quit the program, have a good day!");
//    }
//
//    // MODIFIES: this
//    // EFFECTS: processes user command
//    @SuppressWarnings("methodlength")
//    private void processCommand(String command) {
//        if (command.equals("a")) {
//            // over you want to process more input for name, size, color, category, date
//            // store all of them in variables
//            // then call
//            System.out.println("Item name: ");
//            String itemName = input.next();
//
//            System.out.println("Item size (number): ");
//            int itemSize = input.nextInt();
//
//            System.out.println("Item price: ");
//            int itemPrice = input.nextInt();
//
//            System.out.println("Item category: ");
//            String itemCategory = input.next();
//
//            catalogue.addClothItem(itemName, itemSize, itemPrice, itemCategory);
//
//            System.out.println("Item was successfully added!");
//
//        } else if (command.equals("r")) {
//            System.out.println("Type in item name to be removed from catalogue: ");
//            String itemName = input.next();
//            catalogue.removeClothes(itemName);
//            System.out.println("Item was successfully removed!");
//
//        } else if (command.equals("v")) {
//            printCatalogue();
//        } else if (command.equals("p")) {
//            doSortByPrice();
//        } else if (command.equals("n")) {
//            doSortBySize();
//        } else if (command.equals("s")) {
//            saveWorkRoom();
//        } else if (command.equals("l")) {
//            loadWorkRoom();
//        } else {
//            System.out.println("This selection is not valid...");
//        }
//    }
//
//
//    // EFFECTS: view all clothing in catalogue currently
//    public void printCatalogue() {
//        if (catalogue.getList().isEmpty()) {
//            System.out.println("The catalogue is empty!");
//        } else {
//            for (Clothes item : catalogue.getList()) {
//                System.out.println("name:" + item.getName() + " " + "size:" + item.getSize() + " "
//                        + "$" + item.getPrice()
//                        + " " + "category:" + item.getCategory());
//            }
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: sort clothing item in catalogue from lowest to highest price and print sorted catalogue
//    private void doSortByPrice() {
//        catalogue.sortPrice();
//        System.out.println("The catalogue has been sorted from lowest to highest price");
//        printCatalogue();
//    }
//
//    // MODIFIES: this
//    // EFFECTS: sort clothing item in catalogue from smallest to largest size and print sorted catalogue
//    private void doSortBySize() {
//        catalogue.sortSize();
//        System.out.println("The catalogue has been sorted from smallest to largest size");
//        printCatalogue();
//    }
//
//    // EFFECTS: displays menu of options to user
//    private void displayOptions() {
//        System.out.println("\n Welcome to Vintage Vault!");
//        System.out.println("\n Select Option:");
//        System.out.println("\ta -> add item");
//        System.out.println("\tr -> remove item");
//        System.out.println("\tv -> view catalogue");
//        System.out.println("\tp -> sort catalogue by price");
//        System.out.println("\tn -> sort catalogue by size");
//        System.out.println("\ts -> save work room to file");
//        System.out.println("\tl -> load work room from file");
//        System.out.println("\tq -> quit");
//
//    }
//

