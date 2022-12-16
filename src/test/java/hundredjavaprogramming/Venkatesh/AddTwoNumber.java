package hundredjavaprogramming.Venkatesh;

import java.math.BigInteger;
import java.util.Scanner;

//How to add two number Program in java

public class AddTwoNumber {
	 public static void main(String[] args) {
		    
			BigInteger x, y, sum;
		    Scanner sc = new Scanner(System.in);
		    System.out.println("Type a number:");
		    x = sc.nextBigInteger(); 
		    System.out.println("Type another number:");
		    y = sc.nextBigInteger(); 
		    sum =x.add(y);  
		    System.out.println("Sum is: " + sum); 
		  }

}
