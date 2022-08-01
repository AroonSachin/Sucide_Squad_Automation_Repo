package javaprogrammingpractice.arunsachin;

import java.util.Calendar;
import java.util.TimeZone;

public class Currentdatenewyork {
	public static void main(String[] args) {
		Calendar calNewYork = Calendar.getInstance();
		calNewYork.setTimeZone(TimeZone.getTimeZone("Asia/Japan"));
		System.out.println("Time in New York: " + calNewYork.get(Calendar.HOUR_OF_DAY) + ":"
				+ calNewYork.get(Calendar.MINUTE) + ":" + calNewYork.get(Calendar.SECOND));
		System.out.println();
	}
}
