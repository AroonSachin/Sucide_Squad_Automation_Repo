package javaprogrammingpractice.sowmya;

import java.util.Scanner;

public class Ascending {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int size = s.nextInt(); // whatever we have entered in the console is stored in the variable
		int[] array = new int[size]; // reading the size from the console
		int temp = 0;
		System.out.println("Enter the elements");
		for (int i = 0; i < size; i++) // Storing the values in array
		{

			array[i] = s.nextInt();
		}
		System.out.println("The array of elements are: ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		//Sorting in ascending order
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {

				if (array[i] < array[j]) // comparing the outer loop object with inner loop
				{
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println("The elements in ascending order"); //printing the elements in ascending order
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
	}
}

