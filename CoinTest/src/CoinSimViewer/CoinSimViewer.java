package CoinSimViewer;

//Name:Xijia Chen	
//USC NetID: xijiac
//CS 455 PA1
//Spring 2018

import java.util.Scanner;
import javax.swing.JFrame;
import CoinTossSimulate.CoinTossSimulator;

/**
 * CoinTossSimuViewer class
 * 
 * This class contains prompts for the number of trials. If client input 
 * a eligible number of trial, then it will initialize a new CoinTossSimulator
 * object and a Jframe object, which a CoinSimComponent object is *added* 
 * into
 * 
 */

public class CoinSimViewer {
	public static void main(String[] args){
		
		CoinSimViewer coinsimviewer = new CoinSimViewer();
		coinsimviewer.openViewer();			
	}
	
	/**
		If client input an eligible number(number>0), an CoinTossSimulator
		will be initialized and results of trial will be gotten. A Jframe
		object , where a CoinSimComponent object is put, will also be 
		initialized. Then a rectangle viewer can be seen; If client input
		a wrong number, he will be requested to reinput a new number
		
	*/
	
	private void openViewer() {
		Scanner scan = new Scanner(System.in);
		System.out.print("please enter your trial number:");
		int numTrials = scan.nextInt();
		if(numTrials>0) {
			
			JFrame frame = new JFrame();
			frame.setSize(800, 500);
			frame.setTitle("CoinSim");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
			CoinSimComponent coinComponent = new CoinSimComponent(numTrials);
			frame.add(coinComponent);
		
			frame.setVisible(true);
		}else if(numTrials<=0) {
			System.out.print("ERROR: Number entered must be greater than 0."+"\n" );
			openViewer();
		}	
	}
}
