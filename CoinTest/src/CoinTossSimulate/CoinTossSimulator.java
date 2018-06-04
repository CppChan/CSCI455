package CoinTossSimulate;

// Name:Xijia Chen	
// USC NetID: xijiac
// CS 455 PA1
// Spring 2018

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
import java.util.Random;

public class CoinTossSimulator {

	private int twoHeads, headTails, twoTails, numTrials; 
	private Random generator;
   /**
      Creates a coin toss simulator with no trials done yet.
   */
	public CoinTossSimulator() {
		generator = new Random();
		twoHeads = 0;
		headTails = 0;
		twoTails = 0;
		numTrials = 0;
	}


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
	public void run(int numTrials) {

		this.numTrials = numTrials;
		int buffer1, buffer2;
		for(int i = 0; i<numTrials; i++) {
			buffer1 = generator.nextInt(2);
			buffer2 = generator.nextInt(2);
			if(buffer1 == 0 && buffer2 ==0) {
				twoHeads++;
			}else if(buffer1== 1 && buffer2 ==1) {
				twoTails++;
			}else if((buffer1 == 0 && buffer2 ==1)||(buffer1 == 1 && buffer2 ==0)) {
				headTails++;
			}
		}
	}


   /**
      Get number of trials performed since last reset.
   */
	public int getNumTrials() {
		return numTrials; // DUMMY CODE TO GET IT TO COMPILE
	}


   /**
      Get number of trials that came up two heads since last reset.
   */
	public int getTwoHeads() {
		return twoHeads; // DUMMY CODE TO GET IT TO COMPILE
	}


   /**
     Get number of trials that came up two tails since last reset.
   */  
	public int getTwoTails() {
		return twoTails; // DUMMY CODE TO GET IT TO COMPILE
	}


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
	public int getHeadTails() {
		return headTails; // DUMMY CODE TO GET IT TO COMPILE
	}


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
	public void reset() {
		twoHeads = 0;
		twoTails = 0;
		headTails = 0;
	}
	
}
