package lab2;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Calendar1 {
	public static void main(String args[]) {
		GregorianCalendar gre = new GregorianCalendar(1995,0,20);
		System.out.print((gre.get(Calendar.MONTH)+1)+"/");
		System.out.print(gre.get(Calendar.DATE)+"/");
		System.out.print(gre.get(Calendar.YEAR)+"\n");
		
		gre.add(gre.DATE, 20);
		
		System.out.print((gre.get(Calendar.MONTH)+1)+"/");
		System.out.print(gre.get(Calendar.DATE)+"/");
		System.out.print(gre.get(Calendar.YEAR));
	}
}
