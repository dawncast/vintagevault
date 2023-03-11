package persistence;

import model.Catalogue;
import model.Clothes;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{
    @Test
    void testWriterInvalidFile() {
        try {
            Catalogue catalogue = new Catalogue();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyCatalogue() {
        try {
            Catalogue catalogue = new Catalogue();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCatalogue.json");
            writer.open();
            writer.write(catalogue);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCatalogue.json");
            catalogue = reader.read();
            assertEquals(0, catalogue.getList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralCatalogue() {
        try {
            Catalogue catalogue = new Catalogue();
            catalogue.addClothItem("skirt",4, 20, "bottom");
            catalogue.addClothItem("blouse", 9, 280, "top");
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralCatalogue.json");
            writer.open();
            writer.write(catalogue);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralCatalogue.json");
            catalogue = reader.read();
            List<Clothes> clothesList = catalogue.getList();
            assertEquals(2, clothesList.size());
            checkClothingItem("skirt",4, 20, "bottom", clothesList.get(0));
            checkClothingItem("blouse",9, 280, "top", clothesList.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}


