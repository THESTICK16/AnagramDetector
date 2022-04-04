import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {

    static SetOfLists allAnagrams;

    public static void main(String[] args) {
        allAnagrams = new SetOfLists();
        File dictionaryFile = new File("dict3.txt");
        List<String> dictionary = new ArrayList<>();

        try { //load the dictionary file into a list for easy access
            Scanner dictScan = new Scanner(dictionaryFile);
            while (dictScan.hasNext()) {
                dictionary.add(dictScan.nextLine());
            }
            dictScan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter the word or phrase you would like to find anagrams for: ");
        String phrase = userInput.nextLine(); //the phrase that will have anagrams made of

        System.out.println("Please enter the maximum number of words you would like to be found per anagram: ");
        int maxWords = 0; //the maximum number of words the anagram finder can find for each individual anagram

        if (userInput.hasNextInt())
            maxWords = userInput.nextInt();
        userInput.nextLine();
        while (maxWords <= 0) { //ensures that only a positive non-zero integer is entered for maxWords
            System.out.println("You must enter a whole number greater than 0");
            if (userInput.hasNextInt())
                maxWords = userInput.nextInt();
            userInput.nextLine();
        }
        userInput.close();

        LetterInventory phraseInventory = new LetterInventory(phrase);
        List<String> compatibleWords = new ArrayList<>();

        for (String s : dictionary) { //optimizes fidAnagrams by only passing words that are compatible with the user's phrase
            LetterInventory currentWordInventory = new LetterInventory(s);
            if (phraseInventory.isCompatible(currentWordInventory)) {
                compatibleWords.add(s);
            }
        }

        findAnagrams(phraseInventory, compatibleWords, new ArrayList<String>(), maxWords);
        System.out.println(allAnagrams.toString());
    }

    public static void findAnagrams(LetterInventory inventory, List<String> dictionary, List<String> wordList, int maxWords) {
        if (wordList.size() >= maxWords || inventory.getInventorySize() <= 0) { //the stopping point for the recursive function. stops if the list size is equal to the maximum number of words
            allAnagrams.addList(new ArrayList(wordList));
            wordList.clear();
            return;
        }

        else {
            for (String s : dictionary) {
                LetterInventory wordInventory = new LetterInventory(s);

                if (inventory.isCompatible(wordInventory)) {
                    wordList.add(s);
                    LetterInventory newInventory = inventory.subtract(wordInventory);
                    findAnagrams(newInventory, dictionary, wordList, maxWords); //recursive call to continue searching for anagrams from the current list
                }
            }
            allAnagrams.addList(new ArrayList(wordList));
            wordList.clear();
        }
    }
}
