package javaprogrammingpractice.sowmya;

import java.util.Scanner;

public class AreaOFCircle {

	public static void main(String[] args) {
		System.out.println("Enter the value of radius:");
		Scanner sc=new Scanner(System.in);
		double r=sc.nextDouble();
		double a=3.14*r*r;
		System.out.println("The area of the circle is: \n" + a );

		}

}
