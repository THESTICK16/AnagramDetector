import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * The class that holds a set containing lists of anagrams
 */
public class SetOfLists {

    /**
     * The set that holds lists of anagrams
     */
    private Set<List> stringLists;

    /**
     * constructs an empty set
     */
    public SetOfLists() {
        stringLists = new HashSet<>();
    }

    /**
     * Adds a list of anagrams to the set of anagrams
     * @param newList the list to be added
     * @return true if add is successful, else false
     */
    public boolean addList(List newList) {
        Iterator<List> sliter = stringLists.iterator();
        while (sliter.hasNext()) {
            boolean unique = true;
            List<String> currList = sliter.next();
            Iterator<String> nlIter = newList.iterator();
            while (nlIter.hasNext()) {
                if (!(currList.contains(nlIter.next())))
                    break;
                else if (!nlIter.hasNext())
                    return false;
            }
        }
        return stringLists.add(newList);
    }

    public int getSize() {
        return stringLists.size();
    }

    public String toString() {
        StringBuilder listString = new StringBuilder();
        Iterator<List> iter = stringLists.iterator();

        while (iter.hasNext()) {
            listString.append(iter.next());
            if (iter.hasNext())
                listString.append("\n");
        }
        return listString.toString();
    }
}
