package commonuseractions;
import java.io.ByteArrayInputStream;
import java.util.UUID;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;
import utils.DriverFactory;

public class Allurelistener implements ITestListener  {
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			Allure.addAttachment(UUID.randomUUID().toString(),new ByteArrayInputStream(((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
