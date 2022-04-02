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

        try {
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
        String phrase = userInput.nextLine();
        System.out.println("Please enter the maximum number of words you would like to be found per anagram: ");
        int maxWords = 0;
        if (userInput.hasNextInt())
            maxWords = userInput.nextInt();
        userInput.nextLine();
        while (maxWords <= 0) {
            System.out.println("You must enter a whole number greater than 0");
            if (userInput.hasNextInt())
                maxWords = userInput.nextInt();
            userInput.nextLine();
        }
        userInput.close();

        LetterInventory phraseInventory = new LetterInventory(phrase);
        List<String> compatibleWords = new ArrayList<>();

        for (String s : dictionary) {
            LetterInventory currentWordInventory = new LetterInventory(s);
            if (phraseInventory.isCompatible(currentWordInventory)) {
                compatibleWords.add(s);
            }
/*            try {
                phraseInventory.subtract(currentWordInventory);
                compatibleWords.add(dictionary.get(i));
            } catch (IllegalArgumentException e) {
               // e.printStackTrace();
            }*/
//            if (phraseInventory.subtract(currentWordInventory).getInventorySize() > 0) {
//                compatibleWords.add(dictionary.get(i));
//            }
        }

        findAnagrams(phraseInventory, compatibleWords, new ArrayList<String>(), maxWords);
        System.out.println(allAnagrams.toString());
    }

    public static void findAnagrams(LetterInventory inventory, List<String> dictionary, List<String> wordList, int maxWords) {
//        LetterInventory phraseInventory = new LetterInventory(phrase);
        if (/*inventory.getInventorySize() <= 0 ||*/ wordList.size() >= maxWords) {

            allAnagrams.addList(new ArrayList(wordList));
            wordList.clear();
            //return;
        }
        else {
            for (String s : dictionary) {
                LetterInventory wordInventory = new LetterInventory(s);

                if (inventory.isCompatible(wordInventory)) {
                    wordList.add(s);
                    LetterInventory newInventory = inventory.subtract(wordInventory);
                    findAnagrams(newInventory, dictionary, wordList, maxWords);
                }
            }

//            for (int i = 0; i < dictionary.size(); i++) {
//                LetterInventory wordInventory = new LetterInventory(dictionary.get(i));
////                wordList.add(dictionary.get(i));
//
//                if (inventory.isCompatible(wordInventory)) {
//                    wordList.add(dictionary.get(i));
//                    LetterInventory newInventory = inventory.subtract(wordInventory);
//                    findAnagrams(newInventory, dictionary, wordList, maxWords);
////                    wordList.remove(dictionary.get(i));
//                }

//                try {
//                    inventory = inventory.subtract(wordInventory);
//                    findAnagrams(inventory, dictionary, /*wordList*/new ArrayList<String>(), maxWords);
//                } catch (IllegalArgumentException e) {
//                    allAnagrams.addList(wordList);
//                    return;
//                    //e.printStackTrace();
//                }

//                findAnagrams(inventory, dictionary, /*wordList*/new ArrayList<String>(), maxWords);
                //wordList.remove(dictionary.get(i));
            //}
        }
    }
}
