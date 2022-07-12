package javaprogrammingpractice.venkat;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		int n1 = 1, n2 = 2, n;
		int length;
		System.out.println("enter the length");
		Scanner len = new Scanner(System.in);
		length = len.nextInt();
		System.out.println("upto" + length + " ");
		while (n1 < length) {
			System.out.print(" " + n1);
			n = n1 + n2;
			n1 = n2;
			n2 = n;
		}

	}

}
