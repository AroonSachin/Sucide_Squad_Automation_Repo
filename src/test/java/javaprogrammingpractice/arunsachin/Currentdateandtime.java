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
		SimpleDateFormat date = new SimpleDateFormat();
		date.applyPattern("MMMM/d/yy HH:mm:ss");
		String dat = date.format(cal.getTime());
		System.out.println(dat);
	}
}
