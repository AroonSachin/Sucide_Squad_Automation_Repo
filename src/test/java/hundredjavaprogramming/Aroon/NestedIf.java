package hundredjavaprogramming.Aroon;

import java.util.Scanner;

/**
 * @Question Nested If Clause in Java.
 * @author aroon
 *
 */
public class NestedIf {
	
	public static void nestedIf() {
		Scanner scn = new Scanner(System.in);
		System.out.println(" Please Enter your lucky number ");
		int lucky = scn.nextInt();
		if((lucky>5) && lucky<=10 ) {
			System.out.println(" Your lucky number is graeter than 5 and lesser than 10");
			if(lucky%2==0) {
				System.out.println(" Your lucky number is even ");
			}else {
				System.out.println(" Your lucky number is Odd ");
			}
		}else {
			System.out.println(" Your lucky number is greater than 10 ");
			if(lucky%2==0) {
				System.out.println(" Your lucky number is even ");
			}else {
				System.out.println(" Your lucky number is Odd ");
			}
		}
		
	}
	
	public static void main(String[] args) {
		nestedIf();
	}

}
