package hundredjavaprogramming.Venkatesh;

import java.util.Scanner;

public class IfElseTwo {
	 public static void main(String[]args)
	 { 
	  System.out.println("Enter your age");
	  Scanner sc = new Scanner(System.in);
	  int age = sc.nextInt();   
	  if(age>=18)
	  {
	    System.out.println("Welcome to the voter portal" );
	  }
	  else
	  {
	    System.out.println("Sorry you cannot proceed further");
	  }
	  }

}
