package hundredjavaprogramming.Aroon;

import java.util.Scanner;
/**
 * @Question How to get input using Scanner 
 * @author aroon
 *
 */
public class GetInput {
	
	public static void main(String[] args) {
		System.out.println("Please Enter your name:");
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println("Hi "+str+" How are you");
		
	}

}
