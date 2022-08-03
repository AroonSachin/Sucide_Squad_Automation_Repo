package javaprogrammingpractice.venkat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date ;
public class LastDayOfMonth {

	public static void main(String[] args) {
		usingcalender();
	}
	private static void usingcalender() {
		Calendar cal =new GregorianCalendar(2022,2,0);
		Date date =cal.getTime();
		DateFormat df=new SimpleDateFormat("DD");
		System.out.println(df.format(date));
	}

}
