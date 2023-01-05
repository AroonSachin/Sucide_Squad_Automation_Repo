package hundredjavaprogramming.Aroon;

import java.util.Scanner;

/**
 * @Question Nested If Clause in Java.
 * @author aroon
 *
 */
public class NestedIf {

	
	public static void bar() {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter your age");
		int age = scn.nextInt();
		if(age>21) {
			
			System.out.println("What kind of drink do you want?");
			String drinkName = scn.next();
			if(drinkName.equalsIgnoreCase("Beer")) {
				System.out.println(" Your order will be served shortly, Thank you.");
			}else if (drinkName.equalsIgnoreCase("whiskey")) {
				System.out.println(" Your order will be served shortly, Thank you.");
			}else if(drinkName.equalsIgnoreCase("Rum")) {
				System.out.println(" Your order will be served shortly, Thank you.");
			}else if(drinkName==null) {
				System.out.println(" Yeah just call me if you need something.");
			}else {
				System.out.println(" Sorry! We dont have that drink.");
			}
			
		} else {
			System.out.println(" Would you like to have some Non_Alcoholic drinks ");
			System.out.println("yes-Y        no-N");
			String ans = scn.next();
			if(ans.equalsIgnoreCase("y")) {
				System.out.println(" Your order will be served shortly, Thank you.");
			} else {
				System.out.println(" Yeah just call me if you need something.");
			}
		}
		
	}
	
	public static void main(String[] args) {
		bar();
	}
}
