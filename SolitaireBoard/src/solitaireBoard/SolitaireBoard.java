package solitaireBoard;

//Name:Xijia Chen		
//USC NetID:xijiac
//CSCI455 PA2
//Spring 2018

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/*
class SolitaireBoard
The board for Bulgarian Solitaire.  You can change what the total number of cards is for the game
by changing NUM_FINAL_PILES, below.  Don't change CARD_TOTAL directly, because there are only some values
for CARD_TOTAL that result in a game that terminates.
(See comments below next to named constant declarations for more details on this.)
*/


public class SolitaireBoard {

public static final int NUM_FINAL_PILES = 9;
// number of piles in a final configuration
// (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)

public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
// bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
// see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
// the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

 // Note to students: you may not use an ArrayList -- see assgt description for details.


/**
   Representation invariants:
   1. Element in piles must be integer and 0 <= Element in piles < CARD_TOTAL.
   2. Sum of element in piles is CARD_TOTAL.
   3. Ahead the last positive element in piles, there are no elements that equals to 0.
   4. CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2

   <put rep. invar. comment here>
   
   @param piles   integer array used to store piles
   @param random  random integer generator
 */

private int[]piles;
private Random random;



/**
  Creates a solitaire board with the configuration specified in piles.
  piles has the number of cards in the first pile, then the number of cards in the second pile, etc.
  PRE: piles contains a sequence of positive numbers that sum to SolitaireBoard.CARD_TOTAL
  
  @param piles  an ArrayList that stores initial piles input by user
*/
public SolitaireBoard(ArrayList<Integer> piles) {

   this.piles = new int[CARD_TOTAL];
   for(int i = 0; i<piles.size();i++) {
	   this.piles[i]=piles.get(i);
   }
   assert isValidSolitaireBoard();   // sample assert statement (you will be adding more of these calls)
}


/**
   Creates a solitaire board with a random initial configuration.
*/
public SolitaireBoard() {
	
	this.piles = new int[CARD_TOTAL];
	random = new Random();
	int previousSize = 0;
	int i = 0;
	while(previousSize < CARD_TOTAL) {
		piles[i] = 1+random.nextInt(CARD_TOTAL-previousSize);
		previousSize+=piles[i];
		i++;
	}
	assert isValidSolitaireBoard(); 
}


/**
   Plays one round of Bulgarian solitaire.  Updates the configuration according to the rules
   of Bulgarian solitaire: Takes one card from each pile, and puts them all together in a new pile.
   The old piles that are left will be in the same relative order as before, 
   and the new pile will be at the end.
 */
public void playRound() {
	
	int newPile = 0, i= 0;
	while(piles[i]!=0) {
		piles[i]--;
		newPile++;
		i++;
	}
	int[]pileBuffer = new int[CARD_TOTAL];
	int newIndex = 0;
	for(int j=0; j<newPile;j++) {
		if(piles[j]!=0) {
			pileBuffer[newIndex]=piles[j];
			newIndex++;
		}
	}
	pileBuffer[newIndex]=newPile;
	piles = pileBuffer;
	assert isValidSolitaireBoard();
}

/**
   Returns true iff the current board is at the end of the game.  That is, there are NUM_FINAL_PILES
   piles that are of sizes 1, 2, 3, . . . , NUM_FINAL_PILES, in any order.
 */

public boolean isDone() {
   
	assert isValidSolitaireBoard();
	HashSet noRepeat = new HashSet();
	for(int i = 0; i<NUM_FINAL_PILES; i++) {
		if(piles[i]==0||piles[i]>NUM_FINAL_PILES) {
			return false;
		}else {
			noRepeat.add(piles[i]);
		}
	}
	if(noRepeat.size()==NUM_FINAL_PILES) {
		return true;
	}else return false;  
}


/**
   Returns current board configuration as a string with the format of
   a space-separated list of numbers with no leading or trailing spaces.
   The numbers represent the number of cards in each non-empty pile.
 */
public String configString() {

   assert isValidSolitaireBoard();
   StringBuilder resultBuilder = new StringBuilder();
   int i = 0;
   while(piles[i]!=0) {
	   resultBuilder.append(String.valueOf(piles[i]));
	   resultBuilder.append(" ");
	   i++;//dummy code to get stub to compile
   }
   resultBuilder.delete(resultBuilder.length()-1, resultBuilder.length());
   String result = resultBuilder.toString();
   return result;
}


/**
   Returns true iff the solitaire board data is in a valid state
   (See representation invariant comment for more details.)
 */
private boolean isValidSolitaireBoard() {
   int i = CARD_TOTAL-1;
   int cardSum = 0;
   while(piles[i]==0) {
	   i--;
   }
   for(int j = i; j>=0; j--) {
	   if(piles[j]==0||piles[j]<0) {
		   return false;
	   }else{
		   cardSum+=piles[j];
	   }
   }
   Boolean result = cardSum != CARD_TOTAL ? false:true;
   return result;  // dummy code to get stub to compile

}

public static void main(String args[]) {
	ArrayList<Integer>lists = new ArrayList<Integer>();
	int iq = 1;
	lists.add(1);
	lists.add(3);
	SolitaireBoard s = new SolitaireBoard(lists);
	s.playRound();
	System.out.print(s.configString());;
}


 // <add any additional private methods here>


}