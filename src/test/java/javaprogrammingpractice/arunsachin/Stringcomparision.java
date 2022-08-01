package javaprogrammingpractice.arunsachin;

public class Stringcomparision {
	public static void checkEquality(Object intial, Object end) {
		
		if (String.valueOf(intial).contains(String.valueOf(end))) {
			System.out.println(intial + " & " + end + " is equal");
		} else {
			System.out.println(intial + " & " + end + " is not equal");	
			
		}
	

}
	public static void main(String[] args){
		
		checkEquality("Chennai"," Chennai");
	}

}
