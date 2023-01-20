package javaprogrammingpractice.arunsachin;

import java.util.Scanner;

public class Segregate {

	public static void bubbleshort(int[] arr) {
		int i, j, temp;
		int n = arr.length;
		System.out.println("The length of the array is: "+n);
		for (i = 0; i < n; i++) {
			for (j = 1; j < (n); j++) {
				if (arr[j - 1]> arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter the length of the array");
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int[] arr = new int[a];
		for (int i = 0;i<a;i++) {
		System.out.println("Enter the int value for index "+i);
		arr[i] = scn.nextInt();

		}
		bubbleshort(arr);
		for (int i = 0; i < a; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
