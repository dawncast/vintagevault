package persistence;

import model.Catalogue;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads catalogue from JSON data stored in file
public class JsonReader {
    private String source;

    //EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads catalogue from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Catalogue read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCatalogue(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses catalogue from JSON object and returns it
    private Catalogue parseCatalogue(JSONObject jsonObject) {
        Catalogue catalogue = new Catalogue();
        addClothes(catalogue, jsonObject);
        return catalogue;
    }

    // MODIFIES: catalogue
    // EFFECTS: parses clothes from JSON object and adds them to catalogue
    private void addClothes(Catalogue catalogue, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("clothes");
        for (Object json : jsonArray) {
            JSONObject nextClothItem = (JSONObject) json;
            addClothItem(catalogue, nextClothItem);
        }
    }

    // MODIFIES: catalogue
    // EFFECTS: parses clothItem from JSON object and adds it to catalogue
    private void addClothItem(Catalogue catalogue, JSONObject jsonObject) {
        String itemName = jsonObject.getString("name");
        int itemSize = jsonObject.getInt("size");
        int itemPrice = jsonObject.getInt("price");
        String itemCategory = jsonObject.getString("category");
        //Clothes clothItem = new Clothes(itemName, itemSize, itemPrice, itemCategory);
        catalogue.addClothItem(itemName, itemSize, itemPrice, itemCategory);
    }
}
