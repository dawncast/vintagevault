package persistence;

import model.Catalogue;
import model.Clothes;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Catalogue catalogue = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }


    @Test
    void testReaderEmptyCatalogue() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCatalogue.json");
        try {
            Catalogue catalogue = reader.read();
            assertEquals(0, catalogue.getList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralCatalogue() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCatalogue.json");
        try {
            Catalogue catalogue = reader.read();
            List<Clothes> clothesList = catalogue.getList();
            assertEquals(2, clothesList.size());
            checkClothingItem("skirt",4, 20, "bottom", clothesList.get(0));
            checkClothingItem("blouse",9, 280, "top", clothesList.get(1));
        }  catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
