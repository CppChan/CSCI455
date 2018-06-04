package lab5;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadTester {
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		while (true){
			System.out.print("Enter a space separated list of numbers: ");
			String stringArray = scanner.nextLine();
			
			Scanner lineScanner = new Scanner(stringArray);
			String result = new String();
			while(lineScanner.hasNext()) {
				result = result + " " +lineScanner.next();
			}
			System.out.println("The numbers were: ["+ result + "]");
		}	
	}
	
}
