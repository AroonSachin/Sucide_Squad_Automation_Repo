package hundredjavaprogramming.Aroon;

import java.util.Scanner;

/**
 * @question Find factorial for given number.
 * @author aroon
 *
 */
public class Factorial {
	
	public static void factorial() {
		Scanner scn = new Scanner(System.in);
		System.out.println(" Enter the number for Factorial value.");
		int num = scn.nextInt();
		int facto = 1;
		for(int x=1;x<=num;x++) {
			facto=facto*x;
		}
		System.out.println(" The Factorial of "+num +" is "+facto);
	}

	public static void main(String[] args) {
		factorial();
		
	}

}
