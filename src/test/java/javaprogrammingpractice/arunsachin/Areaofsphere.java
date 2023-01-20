package javaprogrammingpractice.arunsachin;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.github.javafaker.Faker;

import commonuseractions.CommonActionMethods;

public class Areaofsphere extends CommonActionMethods{
	public static void main(String[] args) {
		SimpleDateFormat smp = new SimpleDateFormat("dd/MMM/YYYY");
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the radius of the sphere");
		double radius = scn.nextDouble();
		double result = (4 * 3.14 * (radius * radius));
		System.out.println("The area sphere for the radius " + radius + "is" + result);
		
	}
}
