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

    /**
     * Testing Strategy
     *
     * Test that lists are properly added
     * test that empty lists are added
     * test that duplicate/identical lists are not added
     * test that the lists have been added properly through toString method call
     */
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
        assertTrue(emptySol.addList(new LinkedList()));
    }

    /**
     * Testing Strategy
     *
     * test that sets return the proper size
     * test that empty sets return 0
     * test that returns a different size after adding new lists
     * test that attempting to add duplicates does not affect size
     */
    @Test
    public void getSize() {
        assertEquals(2, sol.getSize());
        assertEquals(0, emptySol.getSize());
        sol.addList(new LinkedList());
        sol.addList(new LinkedList());
        sol.addList(new LinkedList());
        sol.addList(new LinkedList());
        assertEquals(3, sol.getSize());
        List<String> test = new LinkedList<>();
        test.add("abc d");
        sol.addList(test);
        assertEquals(4, sol.getSize());

    }

    /**
     * Testing Strategy
     *
     * test that the string values are returned with each list on a separate line
     * test that empty sets return empty strings
     */
    @Test
    public void testToString() {
        assertEquals("[ABCD, EFGH]\n[IJKL, MNOP]", sol.toString());
        assertEquals("", emptySol.toString());
    }
}