package hundredjavaprogramming.Sowmya;

import java.util.Scanner;

public class SwapVariable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the two values to be swapped: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("the two values before swapping: " + a + " and " + b );
		int temp=a;
		a=b;
		b=temp;
		System.out.println("the two values after swapping: " + a + " and " + b );
	}
}
