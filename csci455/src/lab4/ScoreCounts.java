package lab4;

import java.util.Scanner;

public class ScoreCounts {

    public static final int HIGH_SCORE = 10;


    public static void main(String[] args) {

	int[] counts = new int[HIGH_SCORE+1];

	Scanner in = new Scanner(System.in);

	while (in.hasNextInt()) {
	    int score = in.nextInt();

	    if (score < 0 || score > HIGH_SCORE) {
		System.out.println("BAD SCORE: " + score 
				   + " not counting it.");
	    }
	    else {
		
		counts[score]++;

	    }

	}

	for (int score = 0; score < counts.length; score++) {
	    System.out.println(counts[score] + 
			       " students got a score of " +
			      score);
	}



    }
}
