package javaprogrammingpractice.arunsachin;

import java.util.Scanner;

public class Areaofsphere {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the radius of the sphere");
		double radius = scn.nextDouble();
		double result = (4 * 3.14 * (radius * radius));
		System.out.println("The area sphere for the radius " + radius + "is" + result);
	}
}
