package javaprogrammingpractice.arunsachin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *  Write a Java program that reads a set of integers, and then prints the sum of the even and odd integers using loop
 * @author amaduraiveeran
 *
 */
public class Sumofevenandodd {

	static int even = 0;
	static int odd = 0;
	
	public static void main(String[] args) {
		List<Integer> st = new ArrayList<Integer>();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number of inputs you want to give:");
		int in = scn.nextInt();
		for (int i = 0; i < in; i++) {
			System.out.println("Enter the value to add:");
			int ad = scn.nextInt();
			st.add(ad);
			
		}
		int len = st.size();
		for (int j = 0; j <= len; j++) {
			int number = st.get(j);
			if (number % 2 == 0) {
				even += number;
			} else {
				odd += number;
			}

		}

		System.out.println("Sum of even numbers: " + even);
		System.out.println("Sum of odd numbers: " + odd);

	}

}
