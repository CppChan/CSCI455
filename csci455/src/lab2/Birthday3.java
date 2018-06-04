package lab2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Birthday3 {
	public static void main(String args[]) {
		Calendar cal = Calendar.getInstance();  
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter your birth month [1..12]:");
		int month = in.nextInt();
		
		System.out.print("Enter your birth day of day: ");
		int day = in.nextInt();
		
		System.out.print("Enter your birth year [4-digit year]: ");
		int year = in.nextInt();
		
		if(month<= (cal.get(Calendar.MONTH)+1) && day <= cal.get(Calendar.DATE)) {
			System.out.print("Your birthday has already happened this year."+"\n");
			System.out.print("You're "+(cal.get(Calendar.YEAR)-year)+" years old");
		}else {
			System.out.print("Your birthday has not yet happened this year."+"\n");
			System.out.print("You're "+(cal.get(Calendar.YEAR)-year-1)+" years old");
		}		
	}
}
