package javaprogrammingpractice.sowmya;

import java.util.Scanner;

public class UpperCase {
	static public String move(String str)
	{
		 int len = str.length();
		 String low = "";
		 String upr = "";
		 char ch;
		 for(int i=0; i<len; i++)
		 {
			 ch=str.charAt(i);
			 if(ch>='a' && ch<='z')
			 {
				low +=ch;
			 }
			 else
			 {
				 upr+=ch;
			 }
				 }
		 return upr + low;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the word: ");
		String s=sc.nextLine();
		System.out.println("The original string:  " + s);
		System.out.println("The final string:  " + move(s));



	}

}
