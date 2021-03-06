package scrabble;

//Name:Xijia Chen		 
//USC NetID:xijiac	 
//CS 455 PA4
//Spring 2018

import java.util.ArrayList;

/**
* A Rack of Scrabble tiles
*/

public class Rack {
	
private String unique;
private int[] mult;
private int k;
private ArrayList<String>subsets;

/**
 * Initialized a Rack Rack object.
 * @param unique a string of unique letters
 * @param mult the multiplicity of each letter from unique.  
 * @param k the smallest index of unique and mult to consider.
 * @param all subsets of the indicated multiset.
 */
public Rack(String unique, int[] mult, int k){
	 this.unique = unique;
	 this.mult = mult;
	 this.k = k;
	 subsets = allSubsets(unique, mult, k);
}

public ArrayList<String> getSubsets(){
	return this.subsets;
}

/**
 * Finds all subsets of the multiset starting at position k in unique and mult.
 * unique and mult describe a multiset such that mult[i] is the multiplicity of the char
 *      unique.charAt(i).
 * PRE: mult.length must be at least as big as unique.length()
 *      0 <= k <= unique.length()
 * @param unique a string of unique letters
 * @param mult the multiplicity of each letter from unique.  
 * @param k the smallest index of unique and mult to consider.
 * @return all subsets of the indicated multiset
 * @author Claire Bono
 */
private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
   ArrayList<String> allCombos = new ArrayList<>();
   
   if (k == unique.length()) {  // multiset is empty
      allCombos.add("");
      return allCombos;
   }
   
   // get all subsets of the multiset without the first unique char
   ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
   
   // prepend all possible numbers of the first char (i.e., the one at position k) 
   // to the front of each string in restCombos.  Suppose that char is 'a'...
   
   String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
   for (int n = 0; n <= mult[k]; n++) {   
      for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                     // we found in the recursive call
         // create and add a new string with n 'a's in front of that subset
         allCombos.add(firstPart + restCombos.get(i));  
      }
      firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
   }
   
   return allCombos;
}


}
