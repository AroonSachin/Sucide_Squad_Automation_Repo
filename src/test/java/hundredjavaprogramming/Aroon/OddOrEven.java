package hundredjavaprogramming.Aroon;

import java.util.Scanner;
/**
 * @Question How to check Odd or Even.
 * @author aroon
 *
 */
public class OddOrEven {

	public static void checkOddOrEven() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter a number to find Odd or Even ");
		int num = scn.nextInt();
		if(num%2==0) {
			System.out.println(" The number is even ");
		}else {
			System.out.println(" The number is Odd ");
		}
	}
	
	public static void main(String[] args) {
		
		checkOddOrEven();
	}

}
