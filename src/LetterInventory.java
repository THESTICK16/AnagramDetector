import java.util.Arrays;
import java.util.Locale;

/**
 * a class containing the letter inventory for a given input
 */
public class LetterInventory {

    /**
     * the string containing all the letters in the inventory sorted alphabetically
     */
    private String inventory;

    /**
     * Constructs a letter inventory based on input
     * @param word the word(s) to be input to the inventory
     */
    public LetterInventory(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        inventory = "";
        for (int i = 0; i < chars.length; i ++) {
            if (Character.isLetter(chars[i]))
                inventory = inventory + chars[i];
        }
        inventory = inventory.toLowerCase();
    }

    /**
     * Constructs an empty letter inventory
     */
    public LetterInventory() {
    inventory = "";
    }

    /**
     * Returns the number of times the letter appears in the inventory
     * @param letter the letter to check the count of in the inventory
     * @return the number of times the letter appears in the inventory
     */
    public int getLetterCount(char letter) {
        return -1;
    }

    /**
     * @return the size of the inventory (number of letters)
     */
    public int getInventorySize() {
        return inventory.length();
    }

    /**
     * subtracts the letter counts of compareInventory from this inventory and returns a new inventory with the remaining letters
     * @param compareInventory the inventory to subtract from this inventory
     * @return the new inventory without the duplicat letters in both inventories
     */
    public LetterInventory subtract(LetterInventory compareInventory) {
        return null;
    }

    /**
     * @return a string representation of the inventory
     */
    public String toString() {
        return inventory;
    }
}
