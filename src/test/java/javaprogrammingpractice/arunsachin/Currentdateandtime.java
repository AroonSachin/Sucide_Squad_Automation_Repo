package javaprogrammingpractice.arunsachin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * To print the current date and time.
 * @author amaduraiveeran
 *
 */
public class Currentdateandtime {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.add(7,+20);
		SimpleDateFormat date = new SimpleDateFormat();
		date.applyPattern("MMMMMMMMMM/dd/yyyy");
		String dat = date.format(cal.getTime());
		System.out.println("Current date:"+dat);
	}
}
