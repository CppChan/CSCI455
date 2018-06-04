package scrabble;

//Name: Xijia Chen	
//USC NetID: xijiac	
//CS 455 PA4
//Spring 2018
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/**
* A dictionary of all anagram sets. 
* Note: the processing is case-sensitive; so if the dictionary has all lower
* case words, you will likely want any string you test to have all lower case
* letters too, and likewise if the dictionary words are all upper case.
*/

public class AnagramDictionary {

private Map<String, ArrayList<String>>dictionary;

/**
 * Create an anagram dictionary from the list of words given in the file
 * indicated by fileName.  
 * PRE: The strings in the file are unique.
 * @param fileName  the name of the file to read from
 * @throws FileNotFoundException  if the file is not found
 */
public AnagramDictionary(String fileName) throws FileNotFoundException {
	this.dictionary = new HashMap<String, ArrayList<String>>();
	File file = new File(fileName);
	Scanner in = new Scanner(file);
	buildDictionary(in);
}

/**
 * According to the file user input, build up a Anagram Dictionary, 
 * which was classified based on each set of anagrams.
 * @param in the scanner which has stored the content of the file user input
 */
private void buildDictionary(Scanner in) {
	while(in.hasNext()) {
		String key = in.next();
		String anagramsKey = buildCanonical(key);
		if(dictionary.containsKey(anagramsKey)) {
			ArrayList<String>value1 = dictionary.get(anagramsKey);
			value1.add(key);
			dictionary.put(anagramsKey, value1);
		}else {
			ArrayList<String>value2 = new ArrayList<String>();
			value2.add(key);
			dictionary.put(anagramsKey, value2);
		}
	}
}

/**
 * Get all anagrams of the given string. This method is case-sensitive.
 * E.g. "CARE" and "race" would not be recognized as anagrams.
 * @param s string to process
 * @return a list of the anagrams of s
 * 
 */
public ArrayList<String> getAnagramsOf(String s) {
	ArrayList<String>temp = new ArrayList<String>();
    temp = dictionary.get(buildCanonical(s));
    return temp;
    }

/**
 * According to particular word, build up its canonical version
 * @param word  a particular word in the dictionary
 */
private static String buildCanonical(String word) {
	char charWord[] = word.toCharArray();
    Arrays.sort(charWord);
    return new String(charWord);
}


}
