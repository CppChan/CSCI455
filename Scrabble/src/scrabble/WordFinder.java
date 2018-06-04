package scrabble;

//Name:Xijia Chen		 
//USC NetID:xijiac	 
//CS 455 PA4
//Spring 2018
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordFinder {
	
	/**
	 * Read what user input(a dictionary file); the default value is sowpods.txt;
	 * And use that file to produce a AnagramDictionary object;
	 */
	public static void main(String args[]) {
		
		String fileName = "";
		if(args.length == 0) {
			fileName = "sowpods.txt";
		}else {
			fileName = args[0];
		}
		try {
			AnagramDictionary dic = new AnagramDictionary(fileName);
			findWords(dic);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found: " + fileName);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Give user a prompt to input a letter string he wants to search in the dictionary;
	 * And then found all subsets of this string and their score.
	 * 
	 * @param dic the dictionary user input in previous process
	 */
	private static void findWords(AnagramDictionary dic) {
		String target = "";
		ArrayList<String>subsets = new ArrayList<String>();
		int[]mult = new int[0];
		Scanner in = new Scanner(System.in);
		System.out.println("Type . to quit.");
		while(true) {
			System.out.print("Rack? ");
			target = in.nextLine();
			if(target.equals("."))break;
			mult = sortTarget(target);
			String unique = findUnique(target);
			Rack rack = new Rack(unique, mult, 0);
			subsets = rack.getSubsets();
			ScoreTable table = new ScoreTable();
			TreeMap<String, Integer>result = computeScore(subsets, dic, table);
			ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(result.entrySet()); 
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
				public int compare(Map.Entry<String, Integer>one, Map.Entry<String, Integer>two) {
					return two.getValue()-one.getValue();
				}
			});
			printResult(list, target);

		}
		System.out.print("Program quit.");
	}
	
	/**
	 * Print out the result of the score of the subsets based on a decreasing order
	 * 
	 * @param list  final result list, which stores score of a subset and the exact subset string
	 * @param target  a string that user input
	 */
	
	private static void printResult(ArrayList<Map.Entry<String, Integer>> list, String target) {
		System.out.println("We can make "+list.size()+" words from "+"\""+target+"\"");
		if(list.size()>0)System.out.println("All of the words with their scores (sorted by score):");
		Iterator<Map.Entry<String, Integer>> iter = list.iterator();
		while(iter.hasNext()) {
			Map.Entry<String, Integer> ele = iter.next();
			System.out.println(ele.getValue()+": "+ele.getKey());
		}
	}
	
	/**
	 * According to particular subset in subsets, first compute its score,
	 * then use getAnagramsOf method to find out its anagram. Finally put 
	 * every single anagram word into the resulting TreeMap, which store 
	 * the score and string of each word.
	 * 
	 * @param subsets all subsets string from the target string
	 * @param dic the dictionary user input in previous process
	 * @param table the Scoretable which store each letter's score
	 */
	private static TreeMap<String, Integer> computeScore(ArrayList<String>subsets, AnagramDictionary dic, ScoreTable table) {
		TreeMap<String, Integer>result = new TreeMap<String, Integer>();
		for(int i = 0; i<subsets.size(); i++) {
			String canonical = subsets.get(i);
			int score = table.computeScore(canonical);
			ArrayList<String>content = new ArrayList<String>();
			content = dic.getAnagramsOf(canonical);
			if(content!=null) {
				for(int j = 0; j<content.size(); j++) {
				result.put(content.get(j), score);
				}
			}
			
		}
		return result;
	}
	
	/**
	 * First compute the appearance times of each letter in target string and put
	 * this result in hashmap; then build up an array based on the appearance times
	 * 
	 * @param target  a string that user input
	 */
	private static int[]sortTarget(String target){
		Map<Character, Integer>letter = new TreeMap<Character, Integer>();
		
		for(int i = 0; i<target.length();i++) {
			if(!letter.containsKey(target.charAt(i))) {
				letter.put(target.charAt(i), 1);
			}else {
				letter.put(target.charAt(i), letter.get(target.charAt(i))+1);
			}
		}
		int[]result = new int[letter.size()];
		int i = 0;
		Iterator<Map.Entry<Character, Integer>> iter = letter.entrySet().iterator();
		while(iter.hasNext()) {
			result[i]=iter.next().getValue();
			i++;
		}
		return result;
	}
	
	/**
	 * Based on target string, builds up a unique string which means each letter 
	 * appears for just one time
	 * 
	 * @param target  a string that user input
	 */
	private static String findUnique(String target) {
		String unique = "";
		Set<Character>uniqueSet = new TreeSet<Character>();
		for(int i = 0; i<target.length(); i++){	
			uniqueSet.add(target.charAt(i));
		}
		Iterator iter = uniqueSet.iterator();
		while(iter.hasNext()) {
			unique = unique+iter.next();
		}
		return unique;
	}	
}
