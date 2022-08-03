package javaprogrammingpractice.venkat;

import java.util.ArrayList;

public class JoinTwoArrayLists {

	public static void main(String[] args) {
		 ArrayList<Integer> c1= new ArrayList<Integer>(); 
         c1.add(1);
         c1.add(2);
         c1.add(3);
         c1.add(4);
         System.out.println("List of first array: " + c1);
         ArrayList<Integer> c2= new ArrayList<Integer>();
         c2.add(10);
         c2.add(20);
         c2.add(20);
         c2.add(40);
         System.out.println("List of second array: " + c2);
         ArrayList<Integer> add = new ArrayList<Integer>();
         add.addAll(c1);
         add.addAll(c2);
         System.out.println("New array: " + add);

	}

}
