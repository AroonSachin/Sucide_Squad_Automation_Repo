package javaprogrammingpractice.arunsachin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Portionfromlist {
	 public static List<String> convertArrayToList(String array[])
	    {
	        List<String> list = new ArrayList<>();
	        for (String t : array) {
	            list.add(t);
	        }
	        return list;
	    }
	protected static List<String> splitString(String data) {
				String[] temp = data.split(",");
				
		return convertArrayToList(temp);
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the values by seperating with comma");
		String str = scn.next();
		  List<String> list = splitString(str);
		  System.out.println("Original list: " + list);
		  System.out.println("Enter index number from where you wanna get values:");
		  int frm = scn.nextInt();
		  System.out.println("Enter index number until where you wanna get values:");
		  int len = scn.nextInt();
		  List<String> sub_List = list.subList(frm, len+1);
		  System.out.println("List of first three elements: " + sub_List);
	}
}
