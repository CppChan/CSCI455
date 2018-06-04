package solitaireBoard;

import java.util.ArrayList;

public class Test {
	public static void main(String args[]) {
		ArrayList<Integer>lists = new ArrayList<Integer>();
		int iq = 1;
		lists.add(1);
		lists.add(3);
		SolitaireBoard s = new SolitaireBoard(lists);
		System.out.print(s.configString());;
	}
	
}
