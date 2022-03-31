import static org.junit.Assert.*;
//import org.junit.Test;

public class LetterInventoryTestz {

    private LetterInventory li;
    private LetterInventory li2;
    private LetterInventory li3;
    private LetterInventory emptyLi;
    private LetterInventory noConstructorLi;

    @org.junit.Before
    public void setUp() throws Exception {
        li = new LetterInventory("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        li2 = new LetterInventory("ABCdefgggHhHijKi1l,m.N]o p");
        li3 = new LetterInventory("Blinded Trails");
        emptyLi = new LetterInventory("");
        noConstructorLi = new LetterInventory();

    }

    @org.junit.Test
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

    @org.junit.Test
    public void getInventorySize() {
        assertEquals(26, li.getInventorySize());
        assertEquals(21, li2.getInventorySize());
        assertEquals(13, li3.getInventorySize());
        assertEquals(0, emptyLi.getInventorySize());
        assertEquals(0, noConstructorLi.getInventorySize());
    }

    @org.junit.Test
    public void subtract() {
        assertEquals("ABCDEFGHIJK", li.subtract(new LetterInventory("LMNOPQRSTUVWXYZ")).toString());
        assertEquals("ABCDEFGGGHHHIIJK", li2.subtract(new LetterInventory("LMNOPQRSTUVWXYZ")).toString());
        assertEquals("QRSTUVWXYZ", li.subtract(li2).toString());
        assertEquals("BDDEILN", li3.subtract(new LetterInventory("Trails")).toString());
        assertEquals("", emptyLi.subtract(new LetterInventory("LMNOPQRSTUVWXYZ")).toString());
        assertEquals("", noConstructorLi.subtract(new LetterInventory("LMNOPQRSTUVWXYZ")).toString());
    }

    @org.junit.Test
    public void testToString() {
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", li.toString());
        assertEquals("ABCDEFGGGHHHIIJKLMNOP", li2.toString());
        assertEquals("ABDDEIILLNRST", li3.toString());
        assertEquals("", emptyLi.toString());
        assertEquals("", noConstructorLi.toString());
    }
}