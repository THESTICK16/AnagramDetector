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
        word = word.toUpperCase();
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        inventory = "";
        for (int i = 0; i < chars.length; i ++) {
            if (Character.isLetter(chars[i]))
                inventory = inventory + chars[i];
        }
//        inventory = inventory.toUpperCase();
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
        int count = 0;
        for (int i = 0; i < inventory.length(); i++) {
            if (Character.toUpperCase(letter) == inventory.charAt(i))
                count++;
        }
        return count;
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
        for (int i = 0; i < compareInventory.getInventorySize(); i++) {
            char currentChar = compareInventory.toString().charAt(i);

            for (int j = 0; j < inventory.length(); j++) {
                if (compareInventory.getLetterCount(currentChar) - this.getLetterCount(currentChar) < 0)
                    throw new IllegalArgumentException("Incompatible Word, Subtraction Failed");
            }

        }

        StringBuilder newS = new StringBuilder("");
        for (int i = 0; i < inventory.length(); i++) {
            char currentChar = inventory.charAt(i);
            int numLeft = this.getLetterCount(currentChar) -
                    compareInventory.getLetterCount(currentChar);
            if (i != 0 && currentChar == inventory.charAt(i - 1))
                continue;
            for (int j = 0; j < numLeft; j++) {
                newS.append(inventory.charAt(i));
            }
        }

        return new LetterInventory(newS.toString());
    }

    /**
     * @return a string representation of the inventory
     */
    public String toString() {
        return inventory;
    }
}
