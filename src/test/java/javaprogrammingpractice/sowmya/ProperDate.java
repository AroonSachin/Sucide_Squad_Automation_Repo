package javaprogrammingpractice.sowmya;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class ProperDate {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("The date is: ");
		String date = sc.next();
		
		if(isValid(date)==true)
		{
			System.out.println("Date is in valid format: " + date);
		
		}
		else
		{
			System.err.println("Date is in invalid format: " + date);
	
		}
	}
	
	private static final SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");

    public static boolean isValid(final String date) {

        

        try {
            // why 2008-02-2x, 20-11-02, 12012-04-05 are valid date?
            s.parse(date);
            // strict mode - check 30 or 31 days, leap year
            s.setLenient(false);
            

        } catch (ParseException e) {
            
            return false;
        }

        return true;
    }
		


	      

	}


