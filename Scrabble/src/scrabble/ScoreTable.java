package scrabble;

//Name:Xijia Chen		 
//USC NetID:xijiac	 
//CS 455 PA4
//Spring 2018
import java.util.HashMap;
import java.util.Scanner;

/**
 *  A table used to store the score of each letter;
 */

public class ScoreTable {

	private HashMap<Character, Integer> table;
	static String onepoint = "aeioulnstr";
	static String twopoint = "dg";
	static String threepoint = "bcmp";
	static String fourpoint = "fhvwy";
	static String fivepoint = "k";
	static String eightpoint = "jx";
	static String tenpoint = "qz";
	static String Onepoint = "AEIOULNSTR";
	static String Twopoint = "DG";
	static String Threepoint = "BCMP";
	static String Fourpoint = "FHVWY";
	static String Fivepoint = "K";
	static String Eightpoint = "JX";
	static String Tenpoint = "QZ";
	
	public ScoreTable () {
		table = new HashMap<Character, Integer>();
		putLetter();
		putUpper();
	}
	
	/**
	 * Put score of lower-case letter into the hashmap table;
	 */
	private void putLetter() {
		for(int i = 0; i<onepoint.length(); i++) {
			table.put(onepoint.charAt(i), 1);
		}
		table.put('d', 2);
		table.put('g', 2);
		for(int j = 0; j<threepoint.length();j++) {
			table.put(threepoint.charAt(j),3);
		}
		for(int k = 0; k<fourpoint.length(); k++) {
			table.put(fourpoint.charAt(k),4);
		}
		table.put('k',5);
		table.put('j',8);
		table.put('x',8);
		table.put('q',10);
		table.put('z',10);
	}
	
	/**
	 * Put score of Upper-case letter into the hashmap table;
	 */
	private void putUpper() {
		for(int i = 0; i<Onepoint.length(); i++) {
			table.put(Onepoint.charAt(i), 1);
		}
		table.put('D', 2);
		table.put('G', 2);
		for(int j = 0; j<Threepoint.length();j++) {
			table.put(Threepoint.charAt(j),3);
		}
		for(int k = 0; k<Fourpoint.length(); k++) {
			table.put(Fourpoint.charAt(k),4);
		}
		table.put('K',5);
		table.put('J',8);
		table.put('X',8);
		table.put('Q',10);
		table.put('Z',10);
	}
	
	/**
	 * Compute the score of a particular word string 
	 * 
	 * @param word target string 
	 */
	public int computeScore(String word) {
		int score = 0;
		for(int i = 0; i<word.length();i++) {
			if(!table.containsKey(word.charAt(i))) {}
			else score+=table.get(word.charAt(i));
		}
		return score;
	}
}
