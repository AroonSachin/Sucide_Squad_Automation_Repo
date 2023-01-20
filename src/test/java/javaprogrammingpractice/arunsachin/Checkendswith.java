package javaprogrammingpractice.arunsachin;

import java.util.Scanner;
// Write a Java program to check for a number at the end of a given string
public class Checkendswith {
	static Scanner scn = new Scanner(System.in);
	static String end;
	private static boolean checkEnd(String text) {
		System.out.println("Enter the character's to check whether the given text ends with that:");
		end = scn.next();
		boolean result = text.endsWith(end);

		return result;

	}


	public static void main(String[] args) {

		System.out.println("Enter the Text:");
		String text = scn.next();
		if(checkEnd(text)) {
			System.out.println("The text "+text+" ends with "+end);
		}else {
			System.out.println("The text "+text+" didn't end with "+end);
		}
	}

}
