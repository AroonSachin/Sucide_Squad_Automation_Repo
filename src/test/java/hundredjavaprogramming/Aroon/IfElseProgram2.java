package hundredjavaprogramming.Aroon;

import java.util.Scanner;

public class IfElseProgram2 {
	
	public static String passOrFail() {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter your name");
		String name = scn.next();
		System.out.println("Please enter your Mark");
		
		int str = scn.nextInt();
		if (str<35) {
			
			return "Ha Ha looser! you failed "+name;
			
		}else if (str>35) {
			return "Great work "+name;
		}else {
			return "Please enter your mark";
		}
	}

	public static void main(String[] args) {

		System.out.println(passOrFail());
		
	}

}
