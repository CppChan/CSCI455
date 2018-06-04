package CoinTossSimulate;

//Name:Xijia Chen	
//USC NetID: xijiac
//CS 455 PA1
//Spring 2018

/**
 * CoinTossSimulatorTester class
 * 
 * This class is used to test the functionality of the CoinTossSimulator class.
 * It contains a main method, which implements different number of trial in a 
 * CoinTossSimulator object.
 */

public class CoinTossSimulatorTester {
	
	public static void main(String args[]) {
		
		int testerAccumulate = 0;//used to accumulate the number of trial in the main method;
		CoinTossSimulatorTester tester = new CoinTossSimulatorTester();
		CoinTossSimulator simulator = new CoinTossSimulator();
		tester.giveInfo(simulator, testerAccumulate);
		System.out.print("\n\n");
		
		int FIRST_TRIAL = 1;
		testerAccumulate += FIRST_TRIAL;
		simulator.run(FIRST_TRIAL);
		System.out.print("After run("+FIRST_TRIAL+"):"+"\n");
		tester.giveInfo(simulator, testerAccumulate);
		System.out.print("\n\n");
		
		int SECOND_TRIAL = 10;
		testerAccumulate += SECOND_TRIAL;
		simulator.run(SECOND_TRIAL);
		System.out.print("After run("+SECOND_TRIAL+"):"+"\n");
		tester.giveInfo(simulator, testerAccumulate);
		System.out.print("\n\n");
		
		int THIRD_TRIAL = 100;
		testerAccumulate += THIRD_TRIAL;
		simulator.run(THIRD_TRIAL);
		System.out.print("After run("+THIRD_TRIAL+"):"+"\n");
		tester.giveInfo(simulator, testerAccumulate);
		System.out.print("\n\n");	
		
		simulator.reset();
		testerAccumulate = 0;
		System.out.print("[ . . . output for tests with different number of trials were here . . .]\n" + 
				"\n"+ "After reset"+"\n");
		
		tester.giveInfo(simulator, testerAccumulate);
		System.out.print("\n\n");
		
		FIRST_TRIAL = 100000;
		testerAccumulate += FIRST_TRIAL;
		simulator.run(FIRST_TRIAL);
		System.out.print("After run("+FIRST_TRIAL+"):"+"\n");
		tester.giveInfo(simulator, testerAccumulate);
		System.out.print("\n\n");	
		
	}
	
	/**
    		Delivers and prints out the results of each set of trials. If the
    		CoinTossSimulator object is buggy, it will result in a false
    		expression at the end.
    
    		@param simulator  current CoinTossSimulator object being used
    		@param testerAccumulate  current CoinTossSimulator object's
    		       accumulated number of trial  		
	*/
	
	private void giveInfo(CoinTossSimulator simulator, int testerAccumulate) {
		
		System.out.print("Number of trials [exp:"+testerAccumulate+"]:" + (simulator.getTwoHeads()
				+simulator.getTwoTails()+simulator.getHeadTails()) + "\n");
		System.out.print("Two-head tosses: "+ simulator.getTwoHeads() +"\n");
		System.out.print("Two-tails tosses: "+ simulator.getTwoTails() +"\n");
		System.out.print("One-head one-tail tosses: "+ simulator.getHeadTails() +"\n");
		if(testerAccumulate == (simulator.getTwoHeads()
				+simulator.getTwoTails()+simulator.getHeadTails())) {
			System.out.print("Tosses add up correctly? true");
		}else {
			System.out.print("Tosses add up correctly? false");
		}
	}
}
