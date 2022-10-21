package javaprogrammingpractice.venkat;

import java.util.Scanner;

public class Areaofcuboid {

	public static void main(String[] args) {
		Scanner cube=new Scanner(System.in);
		System.out.println("enter the length of the cuboid");
		int length=cube.nextInt();
		System.out.println("enter the width of the cuboid");
		int width=cube.nextInt();
		System.out.println("enter the height of the cuboid");
		int height=cube.nextInt();

		int answer = 2*((length*width)+(length*height)+(height*width));
		System.out.println("area of the cuboid is "+answer);
	}

}
