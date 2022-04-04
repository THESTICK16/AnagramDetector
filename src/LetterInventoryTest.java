//import org.junit.Test;
//import org.junit.Before;
//import org.junit.Assert;
//
//public class LetterInventoryTest {
//
//    private LetterInventory li;
//    private LetterInventory li2;
//    private LetterInventory li3;
//
//    @org.junit.Before
//    public void setUp() throws Exception {
//        li = new LetterInventory("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
//        li2 = new LetterInventory("ABCdefgggHhHijKi1l,m.N]o p");
//        li3 = new LetterInventory("Blinded Trails");
//    }
//
//    @org.junit.Test
//    public void getLetterCount() {
//        assertEquals(1, li.getLetterCount('a'));
//        assertEquals(1, li.getLetterCount('z'));
//        assertEquals(1, li.getLetterCount('n'));
//        assertEquals(1, li.getLetterCount('G'));
//        assertEquals(1, li.getLetterCount('V'));
//        assertEquals(3, li2.getLetterCount('g'));
//        assertEquals(1, li2.getLetterCount('e'));
//        assertEquals(0, li2.getLetterCount(' '));
//        assertEquals(0, li2.getLetterCount(','));
//        assertEquals(0, li2.getLetterCount('1'));
//        assertEquals(0, li2.getLetterCount(']'));
//        assertEquals(2, li3.getLetterCount('l'));
//        assertEquals(2, li3.getLetterCount('d'));
//        assertEquals(1, li3.getLetterCount('b'));
//
//    }
//
//    @org.junit.Test
//    public void getInventorySize() {
//    }
//
//    @org.junit.Test
//    public void subtract() {
//    }
//
//    @org.junit.Test
//    public void testToString() {
//    }
//}
