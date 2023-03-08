package utils;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import commonuseractions.CommonActionMethods;

public class MailBody extends CommonActionMethods{
	/**
	 * @Method creates the email body structure using html tags
	 * @return String
	 */

	public static String emailBodyCreator(String duration, String projectType) {

		String text = "<h4>Hello Team,</h4>" + "<p>Please find the results for the execution,</p>";

		text = text
				+ "<table style='font-size: 12px; border-collapse: collapse;' width='30%' border='1' bordercolor='black'>"
				+ "<tr bgcolor='gray' align='center' style='color: white;'><td colspan='2'><b>Test Execution Details</b></td></tr>"
				+ "<tr bgcolor='lightgray'><td><b>Test Name</b></td><td align='center'>" + projectType + "</td></tr>"
				+ "<tr><td><b>Triggered by</b></td><td align='center'>"
				+ capitalize(System.getProperty("user.name")) + "</td></tr>"
				+ "<tr bgcolor='lightgray'><td><b>Environment</b></td><td align='center'> Test </td></tr>"
				+ "<tr><td><b>Browser</b></td><td align='center'>" + capitalize("chrome") + "</td></tr>"
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
				+ "</td></tr>" + "</table><br>";
		try {
			emailScenarioTableCreate();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		text = text + mailText + "<p>Thank you</p>";
		
			text = text + "<p>For more details please look into the extent report attached below.</p>";

		return text;
	}

	/**
	 *
	 * @Method create a test table data for email report
	 *
	 * @return
	 * @throws Exception 
	 */
	public static void emailScenarioTableCreate() throws Exception {

		LinkedList<String> testNames = new LinkedList<>(setTestNames);

		for (int j = 0; j < testNames.size(); j++) {

			Set<String> allTest = new TreeSet<>(testNumber.keySet());
			LinkedList<String> listTest = new LinkedList<>(allTest);
			LinkedList<String> scenarios = new LinkedList<>();

			for (int i = 0; i < listTest.size(); i++) {

				if (listTest.get(i).contains(testNames.get(j))) {
					scenarios.add(listTest.get(i));

				}
			}

			mailText = mailText
					+ "<table style='font-size: 12px;' width='100%' border='1' bordercolor='black' align='center'>"
					+ "<tr align='center' bgcolor='gray'>" + "<td colspan='4' align='center' style='color: white;'><b>"
					+ capitalize(" Sucide squad Automation ") + "</b></td></tr>"
					+ "<tr align='center' bgcolor='lightgray'>" + "<th width='5%'><b>#</b></th>"
					+ "<th width='50%'><b>Scenario Description</b></th>" + "<th width='5%'><b>Status</b></th>"
					+ "<th width='40%'><b>Comments</b></th>" + "</tr>";

			for (String element : scenarios) {
				String sNo = restCorrelateJSON(testNumber.toString(),
						element + ".scenario_no");
				String sDescription = restCorrelateJSON(testNumber.toString(),
						element + ".scenario_description");
				String sStatus = restCorrelateJSON(testNumber.toString(),
						element + ".scenario_status");
				String sComments = restCorrelateJSON(testNumber.toString(),
						element + ".scenario_comment");

				if (sStatus.equalsIgnoreCase("passed")) {
					mailText = mailText + "<tr style='color: green; font-size: 12px;'>" + "<td align='center'>" + sNo
							+ "</td>" + "<td>" + sDescription + "</td>" + "<td>" + sStatus + "</td>" + "<td> </td>"
							+ "</tr>";

				} else if (sStatus.equalsIgnoreCase("failed")) {
					mailText = mailText + "<tr style='color: red; font-size: 12px;'>" + "<td align='center'>" + sNo
							+ "</td>" + "<td>" + sDescription + "</td>" + "<td>" + sStatus + "</td>" + "<td>"
							+ sComments + "</td>" + "</tr>";

				} else if (sStatus.equalsIgnoreCase("skipped")) {
					mailText = mailText + "<tr style='color: orange; font-size: 12px;'>" + "<td align='center'>" + sNo
							+ "</td>" + "<td>" + sDescription + "</td>" + "<td>" + sStatus + "</td>" + "<td>"
							+ sComments + "</td>" + "</tr>";
				}

			}

			mailText = mailText + "</table><br>";

		}
	}
}
