package utils;
import java.util.LinkedList;

import commonuseractions.CommonActionMethods;
import commonuseractions.MailTestListener;



;

public class MailBody extends MailTestListener{
	  
	/**
	 * @Method creates the email body structure using html tags
	 * @return String
	 * @throws Exception 
	 */
    
	public static synchronized String emailBodyCreator(String duration, String projectType) throws Exception {

		String text = "<h4>Hello Team,</h4>" + "<p>Please find the results for the execution,</p>";

		text = text
				+ "<table style='font-size: 12px; border-collapse: collapse;' width='30%' border='1' bordercolor='black'>"
				+ "<tr bgcolor='gray' align='center' style='color: white;'><td colspan='2'><b>Test Execution Details</b></td></tr>"
				+ "<tr bgcolor='lightgray'><td><b>Test Name</b></td><td align='center'>" + projectType + "</td></tr>"
				+ "<tr><td><b>Triggered by</b></td><td align='center'>"
				+ CommonActionMethods.capitalize(System.getProperty("user.name")) + "</td></tr>"
				+ "<tr bgcolor='lightgray'><td><b>Environment</b></td><td align='center'> Prod </td></tr>"
				+ "<tr><td><b>Browser</b></td><td align='center'>" + CommonActionMethods.capitalize("chrome") + "</td></tr>"
				+ "<tr bgcolor='lightgray'><td><b>Machine</b></td><td align='center'>" + System.getProperty("os.name")
				+ "</td></tr>";

		text = text
				+ "<tr bgcolor='gray' align='center' style='color: white;'><td colspan='2'><b>Test Case Details</b></td></tr>"
				+ "<tr><td><b>Overall Test Duration</b></td><td align='center'>" + duration + "</td></tr>"
				+ "<tr bgcolor='lightgray'><td><b>Overall Test case Executed</b></td><td align='center'>"
				+ (passed + failure + skipping) + "</td></tr>"
				+ "<tr><td><b>Test Passed</b></td><td style='color: green;' align='center'>" + passed + "</td></tr>"
				+ "<tr bgcolor='lightgray'><td><b>Test Failed</b></td><td style='color: red;' align='center'>" + failure
				+ "</td></tr>" + "<tr><td><b>Test Skipped</b></td><td style='color: orange;' align='center'>" + skipping
				+ "</td></tr>" + "</table><br><table style='font-size: 12px;' width='100%' border='1' bordercolor='black' align='center'>";
		        emailScenarioTableCreate() ;
		text = text +  mailText  + "<p>Thank you</p>"+"<img src='../../Snaps/1662485837710.png' alt='Computer Man' style='width:48px;height:48px;'>";

		if (System.getenv("JOB_NAME") != null && System.getProperty("os.name").contains("Linux")) {

			text = text + "<p>For more details please look into the extent report attached below.</p>";
		} else {
			text = text + "<p>For more details please look into the extent report attached below.</p>";
		}

		return text;
	}

	/**
	 * 
	 * @Method create a test table data for email report
	 * 
	 * @return
	 */
	public static void emailScenarioTableCreate() {
         
		LinkedList<String> testNames = new LinkedList<String>(setTestNames);
		for (int j = 1; j <=testNames.size(); j++) {

			mailText = mailText
					+ "<tr align='center' bgcolor='gray'>" + "<td colspan='4' align='center' style='color: white;'><b>"
					+ CommonActionMethods.capitalize("Swaglab") + "</b></td></tr>"
					+ "<tr align='center' bgcolor='lightgray'>" + "<th width='5%'><b>S.no.</b></th>"
					+ "<th width='50%'><b>Scenario Description</b></th>" + "<th width='5%'><b>Status</b></th>"
					+ "<th width='40%'><b> Comments </b></th>" + "</tr>";

				if (getScenarioStatus().equalsIgnoreCase("passed")) {
					mailText = mailText + "<tr style='color: green; font-size: 12px;'>" + "<td align='center'>" + j
							+ "</td>" + "<td>" + getScenarioDescription() + "</td>" + "<td>" + getScenarioStatus() + "</td>" + "<td>" +getScenarioComments() + "</td>"
							+ "</tr>";

				} else if (getScenarioStatus().equalsIgnoreCase("failed")) {
					mailText = mailText + "<tr style='color: red; font-size: 12px;'>" + "<td align='center'>" + j
							+ "</td>" + "<td>" + getScenarioDescription() + "</td>" + "<td>" + getScenarioStatus() + "</td>" + "<td>"
							+ getScenarioComments() +  "</td>" + "</tr>";

				} else if (getScenarioStatus().equalsIgnoreCase("skipped")) {
					mailText = mailText + "<tr style='color: orange; font-size: 12px;'>" + "<td align='center'>" + j
							+ "</td>" + "<td>" + getScenarioDescription() + "</td>" + "<td>" + getScenarioStatus() + "</td>" + "<td>"
							+getScenarioComments() + "</td>" + "</tr>";
				}

			}

			mailText = mailText + "</table><br>";

		}
	}

