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
        word = word.toUpperCase(); //ensures all inventories rely on capital letters (for ascii values and comparisons
        char[] chars = word.toCharArray();
        Arrays.sort(chars); //ensures the inventory will be in alphabetical order
        inventory = "";
        for (int i = 0; i < chars.length; i ++) {
            if (Character.isLetter(chars[i])) { //ensures no non-letter characters make it into the array (reduces runtime and avoids errors, bugs, and confusion)
                inventory = inventory + chars[i];
                letterCount[chars[i] - 'A']++; //Subtract the ascii value of A to get the the proper index for the letter (ex. 'A' - 'A' = 0)
            }
        }
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
        if (!Character.isLetter(letter))
            return 0;
        return letterCount[Character.toUpperCase(letter) - 'A']; //Subtract the ascii value of A to get the the proper index for the letter (ex. 'A' - 'A' = 0)
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

            if (this.getLetterCount(currentChar) - compareInventory.getLetterCount(currentChar) < 0) //Ensures that no inventories containing letters that 'this' does not have are not attempted to be subtracted
                throw new IllegalArgumentException("Incompatible Word, Subtraction Failed");
        }

        StringBuilder newS = new StringBuilder("");
        for (int i = 0; i < inventory.length(); i++) {
            char currentChar = inventory.charAt(i);
            int numLeft = this.getLetterCount(currentChar) -
                    compareInventory.getLetterCount(currentChar);
            if (i != 0 && currentChar == inventory.charAt(i - 1)) //ensures that duplicate letters are not added more than they should be. This works properly since the lists are all alphabetical
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

            if (this.getLetterCount(currentChar) - compareInventory.getLetterCount(currentChar) < 0)
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
