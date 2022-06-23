package commonuseractions;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActionMethods {
	
	
	
		
	
	   
	public static void clickMethod(WebElement elements,String value)  {
		try {
					
			elements.click( );
				
			
		} catch (Exception e) {
			
			
			
		}
	}
		public static  void sendKeysMethod(WebElement keys,String enter) {
			try {
				keys.click();
				keys.sendKeys(enter);
				
				
			} catch (Exception e) {
				
				
				
			}
			
			}
		
		
		
		
}
	
	
	
	
	
	
	

}
