package javaprogrammingpractice.sowmya;

import java.time.LocalDate;

public class Date {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println("\n The current date: "  + today);
		System.out.println("\n Ten days before today will be: " + today.plusDays(-20) );
		System.out.println("\n Ten days after today will be: " + today.plusDays(+20));
		
		}

}
