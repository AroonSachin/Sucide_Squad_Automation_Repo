package hundredjavaprogramming.Sowmya;

import java.util.Scanner;

public class SwapTwoNumbersWithoutThirdValue {

	public static void main(String[] args) {
		System.out.println("Enter the two values: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("The values of a and b before swapping: " +  a + " and " + b);
		a = a+b;
		b=a-b;
		a=a-b;
		System.out.println("the values of a and b after swapping: " + a + " and " + b);

	}

}
