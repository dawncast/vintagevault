package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class CatalogueTest {
    private Catalogue testCatalogue;

    @BeforeEach
    void setUp() {
        testCatalogue = new Catalogue();
    }

    @Test
    void testCatalogueConstructor() {
        assertTrue( testCatalogue.getList().isEmpty());
    }

    @Test
    void testAddOneItem() {
        testCatalogue.addClothItem("miniskirt", 6, 50, "bottom");
        assertEquals(1, testCatalogue.getList().size());
        assertEquals("miniskirt", testCatalogue.getList().get(0).getName());
    }

    @Test
    void testAddMultiple() {
       testCatalogue.addClothItem("miniskirt", 6, 50, "bottom");
       testCatalogue.addClothItem("cami", 2, 12, "top");
       testCatalogue.addClothItem("harley-davidson jacket", 75, 50, "outerwear");
       assertEquals(3, testCatalogue.getList().size());
       assertEquals("miniskirt", testCatalogue.getList().get(0).getName());
       assertEquals("cami", testCatalogue.getList().get(1).getName());
       assertEquals("harley-davidson jacket", testCatalogue.getList().get(2).getName());
    }

    @Test
    void testRemoveOne() {
        testCatalogue.addClothItem("miniskirt", 6, 50, "bottom");
        testCatalogue.addClothItem("cami", 2, 12, "top");
        testCatalogue.addClothItem("harley-davidson jacket", 75, 50, "outerwear");
        testCatalogue.removeClothes("miniskirt");
        assertEquals(2, testCatalogue.getList().size());
    }

    @Test
    void testRemoveMultiple() {
        testCatalogue.addClothItem("miniskirt", 6, 50, "bottom");
        testCatalogue.addClothItem("cami", 2, 12, "top");
        testCatalogue.addClothItem("harley-davidson jacket", 75, 50, "outerwear");
        testCatalogue.removeClothes("miniskirt");
        testCatalogue.removeClothes("cami");
        assertEquals(1,testCatalogue.getList().size());
        assertEquals("harley-davidson jacket", testCatalogue.getList().get(0).getName());

    }


    @Test
    void testSortPrice() {
        testCatalogue.addClothItem("miniskirt", 6, 50, "bottom");
        assertEquals("miniskirt", testCatalogue.getList().get(0).getName());
        testCatalogue.addClothItem("cami", 2, 12, "top");
        assertEquals("cami", testCatalogue.getList().get(1).getName());
        testCatalogue.addClothItem("harley-davidson jacket", 75, 98, "outerwear");
        testCatalogue.sortPrice();
        assertEquals("miniskirt", testCatalogue.getList().get(1).getName());
        assertEquals("cami", testCatalogue.getList().get(0).getName());
        assertEquals("harley-davidson jacket", testCatalogue.getList().get(2).getName());
    }

    @Test
    void testSortSize() {
        testCatalogue.addClothItem("miniskirt", 6, 50, "bottom");
        assertEquals("miniskirt", testCatalogue.getList().get(0).getName());
        testCatalogue.addClothItem("cami", 2, 12, "top");
        assertEquals("cami", testCatalogue.getList().get(1).getName());
        testCatalogue.addClothItem("harley-davidson jacket", 14, 98, "outerwear");
        testCatalogue.addClothItem("legwarmers",0, 5, "accessories");
        testCatalogue.sortSize();
        assertEquals("cami", testCatalogue.getList().get(1).getName());
        assertEquals("harley-davidson jacket", testCatalogue.getList().get(3).getName());
        assertEquals("legwarmers", testCatalogue.getList().get(0).getName());

    }

}