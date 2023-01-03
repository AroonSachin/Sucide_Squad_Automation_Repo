package hundredjavaprogramming.Venkatesh;

import java.util.Scanner;
//If Else clause in java- Program 2

public class IfElseTwo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type a number:");
		int number = sc.nextInt();
		if (number > 0) {
			System.out.println("POSITIVE");
		} else if (number < 0) {
			System.out.println("NEGATIVE");
		} else {
			System.out.println("ZERO");
		}
	}

}
