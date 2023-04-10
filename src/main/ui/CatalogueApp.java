package ui;

import model.Catalogue;
import model.Clothes;
import model.Event;
import model.EventLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//represents a catalogue app that users can interact with
public class CatalogueApp extends JFrame {
    public static final int WIDTH = 515;
    public static final int HEIGHT = 525;

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
        catalogueUI();
        EventLog.getInstance().clear();
    }

    // EFFECTS: constructs the catalogue GUI
    public void catalogueUI() {
        frame = new JFrame(); //creates a frame

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                for (Event event : EventLog.getInstance()) {
                    System.out.println(event.toString() + "\n");
                }
                System.exit(0);
            }
        }
        );

        frame.setSize(WIDTH, HEIGHT); //sets x and y dimension of frame
        frame.setTitle("Vintage Vault"); //sets title for frame
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application

        JLabel contentPane = new JLabel(
                new ImageIcon("/Users/sangitadutta/Desktop/cpsc210/project_o4l8z/resources/aiCatalogue.jpg"));
        frame.setContentPane(contentPane);

        menuButton();

        frame.setVisible(true); //make frame visible
    }

    // EFFECTS: create menu buttons that are able to perform function specified by its button name
    // MODIFIES: this

    @SuppressWarnings("methodlength")
    private void menuButton() {
        JButton addButton = new JButton("add clothing item");
        addButton.setBounds(10, 100, 200, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addActionFrame = new JFrame();
                addActionFrame.setVisible(true);
                addActionFrame.setSize(400, 300);
                addActionFrame.setBackground(new Color(229, 204, 255));
                addActionFrame.setResizable(false);


                JPanel panel = new JPanel();
                addActionFrame.add(panel);

                JLabel nameLabel = new JLabel("clothing name: ");
                nameLabel.setBounds(10, 20, 80, 20);
                panel.add(nameLabel);

                JTextField nameText = new JTextField(20);
                nameText.setBounds(100, 20, 165, 25);
                panel.add(nameText);

                JLabel sizeLabel = new JLabel("clothing size: ");
                sizeLabel.setBounds(10, 40, 80, 25);
                panel.add(sizeLabel);

                JTextField sizeText = new JTextField(20);
                sizeText.setBounds(100, 40, 165, 25);
                panel.add(sizeText);

                JLabel priceLabel = new JLabel("clothing price: ");
                priceLabel.setBounds(10, 60, 80, 25);
                panel.add(priceLabel);

                JTextField priceText = new JTextField(20);
                priceText.setBounds(100, 60, 165, 25);
                panel.add(priceText);

                JLabel categoryLabel = new JLabel("clothing category: ");
                categoryLabel.setBounds(10, 80, 80, 25);
                panel.add(categoryLabel);

                JTextField cateText = new JTextField(20);
                cateText.setBounds(100, 80, 165, 25);
                panel.add(cateText);

                JLabel doneLabel = new JLabel("successfully added!");
                doneLabel.setBounds(10, 100, 80, 25);
                doneLabel.setVisible(false);
                panel.add(doneLabel);

                JButton doneButton = new JButton();
                doneButton.setBounds(10, 120, 80, 25);
                doneButton.setText("done");
                panel.add(doneButton);
                doneButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        doneLabel.setVisible(true);

                        String itemName = nameText.getText();
                        int itemSize = Integer.parseInt(sizeText.getText());
                        int itemPrice = Integer.parseInt(priceText.getText());
                        String itemCategory = cateText.getText();

                        catalogue.addClothItem(itemName, itemSize, itemPrice, itemCategory);
                    }
                });
            }
        });

        JButton removeButton = new JButton("remove clothing item");
        removeButton.setBounds(10, 150, 200, 30);
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

                JLabel doneLabel = new JLabel("successfully removed!");
                doneLabel.setBounds(10, 20, 80, 25);
                doneLabel.setVisible(false);
                panel.add(doneLabel);

                JButton doneButton = new JButton();
                doneButton.setBounds(10, 80, 80, 25);
                doneButton.setText("done");
                panel.add(doneButton);
                doneButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        doneLabel.setVisible(true);

                        String itemName = nameText.getText();
                        catalogue.removeClothes(itemName);
                    }
                });
            }
        });

        JButton viewButton = new JButton("view catalogue");
        viewButton.setBounds(10, 200, 200, 30);
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
                    emptyMessage.setBounds(10, 80, 80, 25);
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
        saveButton.setBounds(10, 300, 200, 30);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveWorkRoom();
            }
        });

        JButton loadButton = new JButton("load catalogue");
        loadButton.setBounds(10, 350, 200, 30);
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



