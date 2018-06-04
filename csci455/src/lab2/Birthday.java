package lab2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Birthday {
	public static void main(String args[]) {
		GregorianCalendar gre = new GregorianCalendar(2018,0,18);
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter your birth month [1..12]:");
		int month = in.nextInt();
		
		System.out.print("Enter your birth day of day: ");
		int day = in.nextInt();
		
		System.out.print("Enter your birth year [4-digit year]: ");
		int year = in.nextInt();
		
		if( month<=1 && day <= 18) {
			System.out.print("Your birthday has already happened this year.");
		}else {
			System.out.print("Your birthday has not yet happened this year.");
		}		
	}
}
