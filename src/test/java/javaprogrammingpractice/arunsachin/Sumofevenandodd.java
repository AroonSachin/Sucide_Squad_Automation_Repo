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
//		Scanner scn = new Scanner(System.in);
//		System.out.println("Enter the number of inputs you want to give:");
//		int len = scn.nextInt();
//		int[] arr = new int[len];
//		
//		for (int i = 0; i <= len; i++) {
//			System.out.println("Enter the value to store in index "+i);
//			arr[i] = scn.nextInt();	
//		}
		int[] arr = new int[5];
		
		arr[0] = 12;
		arr[1] = 23;
		arr[2] = 50;
		arr[3] = 55;
		arr[4] = 56;
		
		int siz = arr.length;
		for (int j = 0; j < siz; j++) {
			int number = arr[j];
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
