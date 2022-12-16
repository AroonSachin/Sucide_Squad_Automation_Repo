package hundredjavaprogramming.Aroon;

import java.util.Scanner;
/**
 * @Question If Else Clause Program 2.
 * @author aroon
 *
 */
public class IfClause2 {
	
	
	public static String greet() {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter your name");
		String name = scn.next();
		System.out.println("Say Hi or Hello");
		
		String str = scn.next();
		if (str.equalsIgnoreCase("hi")) {
			
			return "Hello "+name;
			
		}else if (str.equalsIgnoreCase("hello")) {
			return "Hi name"+name;
		}else {
			return "Please say Hi or Hello";
		}
	}
	
public static void main(String[] args) {
	System.out.println(greet());
	
}

}
