package lab4;

import java.util.ArrayList;
import java.util.Collections;

/**
Stores a sequence of integer data values and supports some computations
with it.

CS 455 Lab 4.
*/
public class Nums {


	private ArrayList<Integer>numlist;
 /**
    Create an empty sequence of nums.
  */
 public Nums () {
	 numlist = new ArrayList<Integer>();
 }

 
 /**
    Add a value to the end of the sequence.
  */
 public void add(int value) {
	 numlist.add(value);
 }


 /**
    Return the minimum value in the sequence.
    If the sequence is empty, returns Integer.MAX_VALUE
  */
 public int minVal() {
	
	if(numlist.size()==0) {
		return Integer.MAX_VALUE;
	}else {
		ArrayList<Integer>newlist = new ArrayList<Integer>();
		Collections.sort(numlist);
		return(numlist.get(0));
	}
	// stub code to get it to compile

 }

 /**
    Prints out the sequence of values as a space-separated list 
    on one line surrounded by parentheses.
    Does not print a newline.
    E.g., "(3 7 4 10 2 7)", for empty sequence: "()"
 */
 public void printVals() {
	 System.out.print("(");
	 for( int i = 0; i<numlist.size();i++) {
		 System.out.print(numlist.get(i)+" ");
	 }
	 System.out.print(")");
 }

 /**
    Returns a new Nums object with all the values from this Nums
    object that are above the given threshold.  The values in the
    new object are in the same order as in this one.
    E.g.: call to myNums.valuesGT(10) where myNums = (3 7 19 4 21 19 10)
          returns      (19 21 19)
          myNums after call:  (3 7 19 4 21 19 10)
    The method does not modify the object the method is called on.
  */
 public Nums valuesGT(int threshold) {
	Nums nums = new Nums();
	for(int i = 0; i<numlist.size(); i++) {
		if(numlist.get(i)>threshold) {
			nums.numlist.add(this.numlist.get(i));
		}
	}
	return nums;
	  // stub code to get it to compile

 }

 
}