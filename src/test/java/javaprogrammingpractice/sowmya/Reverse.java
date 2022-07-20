package javaprogrammingpractice.sowmya;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string");
		String str=sc.nextLine();
		String str1="";
		char ch;
		for(int i=0; i<str.length(); i++)
		{
		  ch=str.charAt(i);
		  str1=ch+str1;
		}
		
		System.out.println("The reverse string is: " + str1);
		
		
	}

}
