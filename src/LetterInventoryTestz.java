import org.junit.Test;

import static org.junit.Assert.*;
//import org.junit.Test;

public class LetterInventoryTestz {

    private LetterInventory li;
    private LetterInventory li2;
    private LetterInventory li3;
    private LetterInventory li4;
    private LetterInventory emptyLi;
    private LetterInventory noConstructorLi;

    @org.junit.Before
    public void setUp() throws Exception {
        li = new LetterInventory("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        li2 = new LetterInventory("ABCdefgggHhHijKi1l,m.N]o p");
        li3 = new LetterInventory("Blinded Trails");
        li4 = new LetterInventory("break point");
        emptyLi = new LetterInventory("");
        noConstructorLi = new LetterInventory();

    }

    /**
     * Testing Strategy
     * test that the method returns the proper count for the number of a letter in an inventory
     * test that empty inventories return 0
     * test that the method returns zero if the letter is not present or a non-letter is passed
     */
    @org.junit.Test //(expected = IllegalArgumentException.class)
    public void getLetterCount() {
        assertEquals(1, li.getLetterCount('a'));
        assertEquals(1, li.getLetterCount('z'));
        assertEquals(1, li.getLetterCount('n'));
        assertEquals(1, li.getLetterCount('G'));
        assertEquals(1, li.getLetterCount('V'));
        assertEquals(3, li2.getLetterCount('g'));
        assertEquals(1, li2.getLetterCount('e'));
        assertEquals(0, li2.getLetterCount(' '));
        assertEquals(0, li2.getLetterCount(','));
        assertEquals(0, li2.getLetterCount('1'));
        assertEquals(0, li2.getLetterCount(']'));
        assertEquals(2, li3.getLetterCount('l'));
        assertEquals(2, li3.getLetterCount('d'));
        assertEquals(1, li3.getLetterCount('b'));
        assertEquals(0, emptyLi.getLetterCount('g'));
        assertEquals(0, noConstructorLi.getLetterCount('g'));
    }

    /**
     * Testing Strategy
     *
     * test that inventories return the proper size
     * test that empty inventories return 0
     */
    @org.junit.Test
    public void getInventorySize() {
        assertEquals(26, li.getInventorySize());
        assertEquals(21, li2.getInventorySize());
        assertEquals(13, li3.getInventorySize());
        assertEquals(0, emptyLi.getInventorySize());
        assertEquals(0, noConstructorLi.getInventorySize());
    }

    /**
     * Testing Strategy
     *
     * test that the proper values are returned in the new inventory created by this method
     * test that an exception is thrown if the inventories are incompatible
     * test that the returned inventory is identical when an empty inventory is passed
     * test that an empty inventory is returned if an identical inventory is passed
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public void subtract() {
        assertEquals("ABCDEFGHIJK", li.subtract(new LetterInventory("LMNOPQRSTUVWXYZ")).toString());
        assertEquals("ABCDEFGGGHHHIIJK", li2.subtract(new LetterInventory("LMNOPQRSTUVWXYZ")).toString());
        assertEquals("QRSTUVWXYZ", li.subtract(li2).toString());
        assertEquals("BDDEILN", li3.subtract(new LetterInventory("Trails")).toString());
        assertEquals("", emptyLi.subtract(new LetterInventory("LMNOPQRSTUVWXYZ")).toString());
        assertEquals("", noConstructorLi.subtract(new LetterInventory("LMNOPQRSTUVWXYZ")).toString());
        li2.subtract(new LetterInventory("Z"));
        assertEquals("", li.subtract(new LetterInventory("ABCDEFGHIJKLMNOPQRSTUVWXYZ")).toString());
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", li.subtract(new LetterInventory("")).toString());
    }

    /**
     * Testing Strategy
     *
     * test that LetterInventories with characters that the other one does not have are deemed incompatible
     * tests that non-letter characters are ommited and do not affect results
     * test that identical strings and empty strings are deemed compatible
     */
    @Test
    public void isCompatible() {
        assertTrue(li.isCompatible(new LetterInventory("abcdefg")));
        assertTrue(li.isCompatible(new LetterInventory("     ,,,...;;;;;[]][_=")));
        assertTrue(li.isCompatible(new LetterInventory("hijkseg")));
        assertFalse(li.isCompatible(new LetterInventory("aabbcdefg")));
        assertTrue(li4.isCompatible(new LetterInventory("brat")));
        assertTrue(li4.isCompatible(new LetterInventory("pain")));
        assertTrue(li.isCompatible(new LetterInventory("ABCDEFGHIJKLMNOPQRSTUVWXYZ")));
        assertTrue(li.isCompatible(new LetterInventory("")));
    }

    /**
     * Testing Strategy
     *
     * covers LetterInventories with values and with no values
     * ensures the the method returns the proper string with characters in the proper order
     */
    @org.junit.Test
    public void testToString() {
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", li.toString());
        assertEquals("ABCDEFGGGHHHIIJKLMNOP", li2.toString());
        assertEquals("ABDDEIILLNRST", li3.toString());
        assertEquals("", emptyLi.toString());
        assertEquals("", noConstructorLi.toString());
    }
}