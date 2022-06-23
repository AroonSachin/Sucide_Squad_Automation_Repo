package commonuseractions;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class CommonActionMethods {
	
	static  Logger logger = Logger.getLogger(CommonActionMethods.class);
	
	   
	public static void clickMethod(WebElement elements,String value)  {
		try {
					
			elements.click( );
			logger.info("element is clicked ");
			
				
			
		} catch (Exception e) {
			
			logger.info("element is not clicked ");
			
			
			
		}
	}
		public static  void sendKeysMethod(WebElement keys,String enter) {
			try {
				keys.click();
				keys.sendKeys(enter);
				logger.info(enter);
				
				
			} catch (Exception e) {
				
				
				
				
			}
			
			}
		
		
		
		
}
	
	
	
	
	
	
	


