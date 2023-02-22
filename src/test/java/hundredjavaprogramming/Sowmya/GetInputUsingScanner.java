package hundredjavaprogramming.Sowmya;

import java.util.Scanner;

public class GetInputUsingScanner {

	public static void main(String[] args) {
		System.out.println("Enter the values");
	    Scanner s = new Scanner(System.in);
	    int a = s.nextInt();
	    int b = s.nextInt();
	    System.out.println("The multiplication of two values is: " + (a*b));

	}

}
