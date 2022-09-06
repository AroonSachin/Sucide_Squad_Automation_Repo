package commonuseractions;


import java.io.IOException;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import utils.Mail;

	
public class MailTestListener implements ITestListener{

		

		private WebDriver driver = null;
		public static ThreadLocal<String> scenarioDescription = new ThreadLocal<String>();
		private static CommonActionMethods com = null;
		public static String mailText = "";
		public static LocalTime startTime;
		public static boolean mailFlag = true;
		public static ThreadLocal<String> FailedScreenShotdestination = new ThreadLocal<String>();
		public static JSONObject testNumber = new JSONObject();
		public static Set<String> setTestNames = new LinkedHashSet<String>();
        public static ThreadLocal<String> scenarioStatus = new ThreadLocal<String>();
        public static ThreadLocal<String> scenarioComments = new ThreadLocal<String>();
		public static int passed = 0;
		public static int failure = 0;
		public static int skipping = 0;

		public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

		public static ThreadLocal<String> scenarioIterate = new ThreadLocal<String>();

		
		
		public static ExtentTest getExtentTest() {
			return test.get();
		}

		

		public static synchronized String getScenarioComments() {
			return scenarioComments.get();
		}

//		public static ThreadLocal<String> scenarioNo = new ThreadLocal<String>();
//
//		public static String getScenarioNumber() {
//			return scenarioNo.get();
//		}

		
		public static synchronized String getScenarioDescription() {
			return scenarioDescription.get();
		}

		

		public static synchronized String getScenarioStatus() {
			return scenarioStatus.get();
		}

//		public static ThreadLocal<Integer> errorLogCount = ThreadLocal.withInitial(() -> {
//			return Integer.valueOf(0);
//		});

//		public static Integer getErrorLogCount() {
//			return errorLogCount.get();
//		}

//		public static ThreadLocal<Integer> totalClassTest = ThreadLocal.withInitial(() -> {
//			return Integer.valueOf(0);
//		});

//		public static Integer getClassTestCount() {
//			return totalClassTest.get();
//		}

		// Extent Report Declarations

		@Override
		public synchronized void onStart(ITestContext context) {
			startTime = LocalTime.now();

			

		}
		public static synchronized void setDescription(String description)
		{
         try {
				
				scenarioDescription.set(description);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public synchronized void onFinish(ITestContext context) {

		}

		//@Override
//		public synchronized void onTestStart(ITestResult result) {
//			totalClassTest.set(getClassTestCount() + 1);
//			//errorLogCount.set(0);
//
//		}

		@Override
		public synchronized void onTestSuccess(ITestResult result) {
			
			passed++;
			if (getScenarioStatus() == null) {
				scenarioStatus.set("Passed");
				scenarioComments.set("Execution is successful");
				//getExtentTest().pass("Scenario Passed");
			}

		}

		@Override
		public synchronized void onTestFailure(ITestResult result) {

			scenarioStatus.set("Failed");
			scenarioComments.set(com.commentMessage);
			FailedScreenShotdestination.set(com.snapPath);
			failure++;
		}

		//@Override
//		public synchronized void onTestSkipped(ITestResult result) {
//
//			//getExtentTest().skip("This scenario has been skipped by user");
//			try {
//				scenarioStatus.set("Skipped");
//				scenarioComments.set("Skip");
//				skipping++;
//				//scenarioNo.set(com.getdata("Number"));
//				scenarioDescription.set(com.getdata("Username"));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			scenarioStatus.set("Skipped");
//
//		}

//		@Override
//		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//
//		}

	}


