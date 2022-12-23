package hundredjavaprogramming.Aroon;

import java.util.Scanner;

/**
 * @question Simple for loop.
 * @author aroon
 *
 */
public class SimpleForLoop {
	
	public static void simpleForLoop() {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number to print in for loop");
		int num = scn.nextInt();
		for(int i=0;i<=num;i++) {
			System.out.println(i);
		}
		
	}
	
	public static void main(String[] args) {
		simpleForLoop();
	}

}
