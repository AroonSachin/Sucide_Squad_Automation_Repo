package javaprogrammingpractice.sowmya;

import java.util.Scanner;

public class Substring {

	public static void main(String[] args) {
		
		        Scanner scanner = new Scanner(System.in);
		        System.out.println("Enter the string: ");
		        String sentence = scanner.nextLine();
		       
		        String str = sentence.substring(2,6);
		        System.out.println(str);
		    }
		

	}


