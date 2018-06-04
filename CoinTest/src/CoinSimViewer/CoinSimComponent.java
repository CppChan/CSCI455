 package CoinSimViewer;

//Name:Xijia Chen	
//USC NetID: xijiac
//CS 455 PA1
//Spring 2018

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import CoinTossSimulate.CoinTossSimulator;

/**
 * CoinSimComponent class
 * 
 * Extended from JComponent, this class runs the simulation and the 
 * result of simulation is then used to manage the layout of the
 * CoinSimComponent object and initialize three bars of the result. 
 * 
 */

public class CoinSimComponent extends JComponent{
	
	private int numTrials,twoHeadsNum,twoTailsNum,headTailsNum;
	
	/**
		The constructor is used to initialize the simulation and obtain
		the number of trials input by client	
		@param the number of trials input by client
	*/
	
	public CoinSimComponent(int numTrials) {
		this.numTrials = numTrials;
		beginSimulate(numTrials);
	}
	
	/**
		Runs simulation and obtain the result of simulation
		@param the number of trials input by client
	*/
	
	public void beginSimulate(int numTrials) {
		CoinTossSimulator simulator = new CoinTossSimulator();
		simulator.run(numTrials);
		twoHeadsNum = simulator.getTwoHeads();
		twoTailsNum = simulator.getTwoTails();
		headTailsNum = simulator.getHeadTails();
	}	
	
	/**
		Initializes three Bar object of three kinds of result and manages layout
		of the CoinSimComponent object seen by client
		@param object stores the graphics state that are used for drawing operations
	*/
	
	public void paintComponent(Graphics g) {
				
		Graphics2D g2 = (Graphics2D) g;
		double scale = (double)(this.getHeight()-2*50-15)/(double)numTrials;

		Bar bar1 = new Bar(this.getHeight()-50, (this.getWidth()-450)/4, 150, (int)(scale*twoHeadsNum), scale, Color.GREEN, 
				"Two Heads: "+ twoHeadsNum + " (" + Math.round(100*((double)twoHeadsNum/(double)numTrials)) + "%)");	
		bar1.draw(g2);
		
		Bar bar2 = new Bar(this.getHeight()-50, (this.getWidth()-450)/2+150, 150, (int)(scale*headTailsNum), scale, Color.RED, 
				"A Head and a Tail: "+ headTailsNum + " (" + Math.round(100*((double)headTailsNum/(double)numTrials)) + "%)");
		bar2.draw(g2);
		
		Bar bar3 = new Bar(this.getHeight()-50, (3*(this.getWidth()-450))/4+300, 150, (int)(scale*twoTailsNum), scale, Color.BLUE, 
				"Two Tails: "+ twoTailsNum + " (" + Math.round(100*((double)twoTailsNum/(double)numTrials)) + "%)");
		bar3.draw(g2);
	}
}
