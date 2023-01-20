package javaprogrammingpractice.arunsachin;

import java.util.Scanner;

// Write a Java program to validate a given phone number (Validate no alphabets, no Special characters, Contains 10 to 12 digit)
public class Numbervalidation {

	public static boolean conAlphabet(String num) {
		try {
		    Long.parseLong(num);
		    return true;
		} catch (NumberFormatException e) {
		    System.out.println("Input contains illegal values");
		}
		return false;
	}

	public static boolean lenthVal(String num) {
		int len =num.length();

		if (len >=10 && len<=12) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean validateNum(String number) {

		if(conAlphabet(number)){
			System.out.println("The number only contains integer");
			return true;
		}else {
			return false;
		}

	}
	public static boolean validateLenth(String number) {

		if (lenthVal(number)) {
			System.out.println("The length of the number is within limits");
			return true;
		}else {
			System.out.println("The length of the number is not within 10 and 12");
			return false;
		}



	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the phone number:");
		String number = scn.next();
		if (validateNum(number)&&validateLenth(number)) {
			System.out.println("valid number");
		}else {
			System.out.println("invalid number");
		}


	}
}
