package hundredjavaprogramming.Aroon;

import java.util.Scanner;
/**
 * @Question IfClause in java.
 * @author aroon
 *
 */
public class IfElse {
	
	
	
	public static String greet() {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter your name");
		String name = scn.next();
		System.out.println("Say Hi or Hello");
		
		String str = scn.next();
		if (str.equalsIgnoreCase("hi") || str.equalsIgnoreCase("hello")) {
			
			return "Hello "+name;
			
		}else {
			return "Please say Hi or Hello";
		}
	}
	
public static void main(String[] args) {
	System.out.println(greet());
	
}
	

}
