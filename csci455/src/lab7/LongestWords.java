package lab7;

import java.util.Scanner;

public class LongestWords {
	public int longestWordLen(String words) {
		  Scanner in = new Scanner(words);
		  if(words.length()==0){
		    return 0;
		  }
		  if(in.hasNext()){
		    int len=in.next().length();
		    return Math.max(len,longestWordLen(words.substring(len)));
		  }
		  return 0;
		}
}
