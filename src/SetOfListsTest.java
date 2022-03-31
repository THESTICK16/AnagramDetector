import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class SetOfListsTest {

    SetOfLists sol;
    SetOfLists emptySol;

    @Before
    public void setUp() throws Exception {
        sol = new SetOfLists();
        emptySol = new SetOfLists();
        List<String> test = new LinkedList<>();
        List<String> test2 = new LinkedList<>();
        test.add("ABCD");
        test.add("EFGH");
        test2.add("IJKL");
        test2.add("MNOP");
        sol.addList(test);
        sol.addList(test2);

    }

    @Test
    public void addList() {
        List<String> test = new LinkedList<>();
        List<String> test2 = new LinkedList<>();
        List<String> test3 = new LinkedList<>();
        List<String> test4 = new LinkedList<>();
        test.add("QRST");
        test.add("UVWX");
        assertTrue(emptySol.addList(test));
        assertFalse(emptySol.addList(test));
        assertEquals("[QRST, UVWX]", emptySol.toString());
        test2.add("YZNO");
        test2.add("WIKN");
        assertTrue(emptySol.addList(test2));
        assertEquals("[QRST, UVWX]\n[YZNO, WIKN]", emptySol.toString());
        test3.add("UVWX");
        test3.add("QRST");
        assertFalse(emptySol.addList(test3));
        test4.add("QRST");
        test4.add("YZNO");
        assertTrue(emptySol.addList(test4));
    }

    @Test
    public void getSize() {
        assertEquals(2, sol.getSize());
        assertEquals(0, emptySol.getSize());
        sol.addList(new LinkedList());
        sol.addList(new LinkedList());
        sol.addList(new LinkedList());
        sol.addList(new LinkedList());
        assertEquals(3, sol.getSize());
    }

    @Test
    public void testToString() {
        assertEquals("[ABCD, EFGH]\n[IJKL, MNOP]", sol.toString());
        assertEquals("", emptySol.toString());
    }
}