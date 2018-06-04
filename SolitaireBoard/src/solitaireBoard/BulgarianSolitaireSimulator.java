package solitaireBoard;

import java.util.ArrayList;
import java.util.Scanner;

//Name:Xijia Chen		
//USC NetID:xijiac
//CSCI455 PA2
//Spring 2018


/**
	Class BulgarianSolitaireSimulator
	
	An class used to simulate the process of the Bulgarian SolitaireBoard game

*/

public class BulgarianSolitaireSimulator {

/**
	In main method. There are two configuration argument. If user input argument -u before
	running the test, the initial list of piles will be input by user. If user input -s, 
	user can control the following game transformation steps. If neither argument is set, 
	the initial list of piles will be generated randomly and the following game steps will
	execute automatically.

*/		
public static void main(String[] args) {
   boolean singleStep = false;
   boolean userConfig = false;
   SolitaireBoard board = null;
   Scanner inputScanner = new Scanner(System.in);
   for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-u")) {
         userConfig = true;
      }
      else if (args[i].equals("-s")) {
         singleStep = true;
      }
   }
   if(userConfig) {
	   System.out.println("Number of total cards is "+ SolitaireBoard.CARD_TOTAL+"\n"+
   "You will be entering the initial configuration of the cards (i.e., how many in each pile)");
	   printInputPiles(inputScanner, board, userConfig, singleStep);
   }else if(singleStep&&!userConfig) {
	   nonautoPlayPiles(inputScanner,board);
   }else if(!userConfig&&!singleStep) {
	   autoPrintRandomPiles(board);
   }
}

/**
	Instructs user to type in the initial piles, which should be in accordance to 
	representation invariants in SolitaireBoard class. If user type in a valid
	pile, SolitaireBoard object will begin to transform based on rules of SolitaireBoard
	game
	
	@param inputScanner  scan what user type in
	@param board  a SolitaireBoard object
	@param userConfig  a boolean used to judge if it is in user-input mode
	@param singleStep  a boolean used to judge if it is in step-control mode
*/
private static void printInputPiles(Scanner inputScanner, SolitaireBoard board, Boolean userConfig, Boolean singleStep) {
	System.out.println("Please enter a space-separated list of positive integers followed by newline:");
	String inputString = inputScanner.nextLine();
	ArrayList<Integer> inputPiles = new ArrayList<Integer>();
	board = isValidSolitaireBoard(inputScanner, inputPiles, board, inputString, userConfig, singleStep);
	if(board != null) {
		if(singleStep) {
			nonautoPlayPiles(inputScanner, board);
		}else if(!singleStep) {
			autoPlayPiles(board);
		}		
	}
}

/**
	Generates a pile list randomly if board has not been initialized. Otherwise pile list 
	must have been configured by user. Then begins to transform the SolitaireBoard object 
	step by step under user's control. Transformation process will be print out
	
	@param inputScanner  scanner used to scan user's press of Return key 
	@param board  a SolitaireBoard object
*/
private static void nonautoPlayPiles(Scanner inputScanner, SolitaireBoard board) {
	if(board == null) {
		board = new SolitaireBoard();
	}
	int round = 1;
	System.out.println("Initial configuration:"+board.configString());
	Boolean isDone = isDoneSinglePlay(board,round);
	while(!isDone) {
		String nullString = inputScanner.nextLine();
		board.playRound();
		round++;
		isDone = isDoneSinglePlay(board,round);
	}
}

/**
	Initializes a randomly generated pile list in a SolitaireBoard object, which 
	then begins to transform automatically according to SolitaireBoard game rules
	
	@param board  a SolitaireBoard object
*/
private static void autoPrintRandomPiles(SolitaireBoard board) {
	board = new SolitaireBoard();
	autoPlayPiles(board);
}

/**
	SolitaireBoard object containing a pile list begins to transform automatically
	according to the playRound method in SolitaireBoard class. Every steps will 
	be print out until the transformation is done.
	
	@param board  SolitaireBoard object being transformed
*/
private static void autoPlayPiles(SolitaireBoard board) {
	System.out.println("Initial configuration:"+board.configString());
	int round = 1;
	while(!board.isDone()) {
		board.playRound();
		System.out.println("["+round+"]"+"Current configuration: "+board.configString());
		round++;
	}
	if(board.isDone()) {
		System.out.println("Done!"+"\n");
	}
}

/**
	Prints out transformation process steps by steps until transformation is done. And
	returns a boolean which represents if the process is done 

	@param board  SolitaireBoard object that is being transformed
	@param round  an integer records the number of time that the transformation runs
*/
private static Boolean isDoneSinglePlay(SolitaireBoard board, int round) {	
	System.out.println("["+round+"]"+"Current configuration: "+board.configString());
	System.out.println("<Type return to continue>");
	if(board.isDone()) {
		System.out.println("Done!"+"\n");
	}
	return board.isDone();
}
 
/**
	Checks if pile list input by user is valid. Validation first begin at checking if 
	user's input is merely number. Then checks if the pile list conforms to representation 
	invariants in SolitaireBoard class. 

	@param inputScanner  scan what user type in, used to implement new printInputPiles method here
	@param inputPiles  an ArrayList that will be used to store pile number
	@param board  SolitaireBoard object
	@param inputString  a string that stands for user's input
	@param userConfig  Boolean used to implement new printInputPiles method here
	@param singleStep  Boolean used to implement new printInputPiles method here
*/
private static SolitaireBoard isValidSolitaireBoard(Scanner inputScanner, ArrayList<Integer>inputPiles, SolitaireBoard board, 
		String inputString, Boolean userConfig, Boolean singleStep) {
	for(int i = 0; i<inputString.length(); i++) {
		if(!Character.isDigit(inputString.charAt(i))&&inputString.charAt(i)!=' ') {
			System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be "+SolitaireBoard.CARD_TOTAL);
			printInputPiles(inputScanner, board, userConfig, singleStep);
			return null;
		}
	}
	board = isConformToInvariants(inputScanner, inputPiles, board, inputString, userConfig, singleStep);
	return board;  
}

/**
	Checks if pile list input by user conforms to representation invariants in SolitaireBoard
	class. If the input pile pass the validation, return a SolitaireBoard object constructed 
	by that valid pile list.

	@param inputScanner  scan what user type in, used to implement new printInputPiles method here
	@param inputPiles  an ArrayList that will be used to store pile number
	@param board  SolitaireBoard object
	@param inputString  a string that stands for user's input
	@param userConfig  Boolean used to implement new printInputPiles method here
	@param singleStep  Boolean used to implement new printInputPiles method here
*/
private static SolitaireBoard isConformToInvariants(Scanner inputScanner, ArrayList<Integer>inputPiles, SolitaireBoard board, 
		String inputString, Boolean userConfig, Boolean singleStep) {
	int cardSum = 0;
	Scanner scanString = new Scanner(inputString);
	while(scanString.hasNext()) {
		inputPiles.add(scanString.nextInt());
	}
	for(int j = inputPiles.size()-1; j>=0; j--) {
		if(inputPiles.get(j)==0||inputPiles.get(j)<0) {
			System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be "+SolitaireBoard.CARD_TOTAL);
			printInputPiles(inputScanner, board, userConfig, singleStep);
			return null;
		}else {
			cardSum+=inputPiles.get(j);
		}	
	}
	board = cardSum != SolitaireBoard.CARD_TOTAL ? null:new SolitaireBoard(inputPiles);
	if(board == null) {
		System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be "+SolitaireBoard.CARD_TOTAL);
		printInputPiles(inputScanner, board, userConfig, singleStep);
		return null;
	}
	return board;
}

}
