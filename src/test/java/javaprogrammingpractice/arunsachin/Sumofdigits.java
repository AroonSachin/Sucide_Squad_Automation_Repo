package javaprogrammingpractice.arunsachin;

import java.util.Scanner;

// Write a Java method to compute the sum of the digits in an integer
public class Sumofdigits {
	public static void main(String[] args) {
		int sum = 0;
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the digit's to add");
		int a = scn.nextInt();

		while (a != 0) {
			sum += a % 10;
			a /= 10;
		}
		System.out.println("The sum if the integer is: " + sum);
	}

}
