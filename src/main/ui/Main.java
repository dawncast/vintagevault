package ui;

import java.io.FileNotFoundException;

// runs the catalogue app
public class Main {
    public static void main(String[] args) {
        try {
            new CatalogueApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
