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
     * An array that counts the number of each char that is in the inventory
     * 'A' = 0, 'Z' = 25
     */
    private int[] letterCount = new int[26];

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
            if (Character.isLetter(chars[i])) {
                inventory = inventory + chars[i];
                letterCount[chars[i] - 'A']++;
            }
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
//        int count = 0;
//        for (int i = 0; i < inventory.length(); i++) {
//            if (Character.toUpperCase(letter) == inventory.charAt(i))
//                count++;
//        }
//        return count;
        if (!Character.isLetter(letter))
            return 0; //throw new IllegalArgumentException("\'letter\' must contain a letter");
        return letterCount[Character.toUpperCase(letter) - 'A'];
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

            if (/*this.getLetterCount(currentChar) <= 0 ||*/ this.getLetterCount(currentChar) - compareInventory.getLetterCount(currentChar) < 0)
                throw new IllegalArgumentException("Incompatible Word, Subtraction Failed");

//            for (int j = 0; j < inventory.length(); j++) {
//                if (compareInventory.getLetterCount(currentChar) - this.getLetterCount(currentChar) < 0)
//                if (inventory.charAt(j) == currentChar)
//                    break;
//                else if (j == inventory.length() - 1)
//                    throw new IllegalArgumentException("Incompatible Word, Subtraction Failed");
//            }

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
     * checks to see if the letters in compareInventory are all contained in this LetterInventory
     * @param compareInventory the inventory to compare to
     * @return true if compatible, else false
     */
    public boolean isCompatible(LetterInventory compareInventory) {
        for (int i = 0; i < compareInventory.getInventorySize(); i++) {
            char currentChar = compareInventory.toString().charAt(i);

            if (/*this.getLetterCount(currentChar) <= 0 ||*/ this.getLetterCount(currentChar) - compareInventory.getLetterCount(currentChar) < 0)
                return false;
        }
        return true;
    }

    /**
     * @return a string representation of the inventory
     */
    public String toString() {
        return inventory;
    }
}
