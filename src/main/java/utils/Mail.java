package utils;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import commonuseractions.MailTestListener;



/**
 * 
 * @This class is used to send the email report
 *
 */
public class Mail extends MailTestListener{

	public static void sendReport() throws IOException {
		// authentication info
		final String username = "sowmya.venkateshwaran@tridentsqa.com";
		final String password = "abcdefghijklmnop@2203";
		String fromEmail = "sowmya.venkateshwaran@tridentsqa.com";
		String toEmail = "sowmya.venkateshwaran@tridentsqa.com";

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		// Start our mail message
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.addRecipients(Message.RecipientType.CC, "mohammedmustafa@tridentsqa.com");

			DateFormat dateFormat = new SimpleDateFormat("dd/MMM/YYYY");
			Date date = new Date();

			if (mailFlag) {
				msg.setSubject("Alert Automation Test Execution Failure " + dateFormat.format(date));
			} else {
				msg.setSubject("Nairalytics Test Automation Report " + dateFormat.format(date));
			}

			Multipart emailContent = new MimeMultipart();

			// Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			String htmlBody;
//			if (mailFlag) {
//				File file = new File(FailedScreenShotdestination.get());
//				System.out.println(file.getName());
//				htmlBody = "<h4>Hello Team,</h4><p><b>Alert!!!</b> The following scenario \"<b>"
//						+ getScenarioDescription() + "</b>\" has failed due to <b>" + getScenarioComments()
//						+ "</b></p><p>Please find the screenshot for the current failed scenario</p><img src=\"cid:image\"alt=\"Barcode\" width=\"350\" height=\"250\" align=\"left\">";
//				// first part (the html)
//				BodyPart messageBodyPart = new MimeBodyPart();
//
//				messageBodyPart.setContent(htmlBody, "text/html");
//				// add it
//				MimeMultipart multipart = new MimeMultipart("related");
//				multipart.addBodyPart(messageBodyPart);
//
//				// second part (the image)
//				messageBodyPart = new MimeBodyPart();
//				DataSource source = new FileDataSource(file);
//				messageBodyPart.setDataHandler(new DataHandler(source));
//				messageBodyPart.setHeader("Content-ID", "<image>");
//
//				// add image to the multipart
//				multipart.addBodyPart(messageBodyPart);
//
//				// put everything together
//				msg.setContent(multipart);
//			} else {
				htmlBody = MailBody.emailBodyCreator(testDuration(), "Swaglab");
			//htmlBody = "<h4>Hello Team,</h4><p><b>Alert!!!</b> The following scenario \"<b>";
				// Email body message creation
				StringBuilder sb = new StringBuilder();
				sb.append(htmlBody);
				textBodyPart.setContent(sb.toString(), "text/html");
//
//				File folder = new File(
//						System.getProperty("user.dir") + "/src/main/java/nairalytics_test_automation_suite/reports/");
//				File[] listOfFiles = folder.listFiles();
//				System.out.println("***" + listOfFiles[0]);
//
//				// Attachment body part.
//				MimeBodyPart pdfAttachment = new MimeBodyPart();
//
//				File[] attachFiles = new File(
//						System.getProperty("user.dir") + "/src/main/java/nairalytics_test_automation_suite/reports/")
//								.listFiles();
//
//				if (attachFiles.length > 0) {
//					// attach file
//					attachFile(attachFiles[0], emailContent, pdfAttachment);
//					if (attachFiles.length > 1) {
//						for (int index = 1; index < attachFiles.length; index++) {
//							attachFile(attachFiles[index], emailContent, new MimeBodyPart());
//						}
//					}
//				}

				// Attach body parts
				emailContent.addBodyPart(textBodyPart);
				//emailContent.addBodyPart(pdfAttachment);

				// Attach multipart to message
				msg.setContent(emailContent);

			//}
			Transport.send(msg);
			System.out.println("Sent message");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @This method to attach the file
	 * 
	 * @param file
	 * 
	 * @param multipart
	 * 
	 * @param messageBodyPart
	 *
	 * @throws Exception
	 */

	public static void attachFile(File file, Multipart multipart, MimeBodyPart messageBodyPart)
			throws MessagingException {
		DataSource source = new FileDataSource(file);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(file.getName());
		multipart.addBodyPart(messageBodyPart);
	}

	/**
	 * Calculate the duration of the total test execution
	 *
	 * @return
	 * @throws Exception
	 */
	public static String testDuration() {

		String hrs = "00";
		String mins = "00";
		String secs = "00";
       
		LocalTime end = LocalTime.now();
		  System.out.println(startTime.toString());
		String[] timeStamp = Duration.between(startTime, end).toString().replaceAll("P|T", "")
				.replaceAll("\\.(.*)|S", "").replaceAll("M|H", " ").split(" ");

		switch (timeStamp.length) {
		case 1:
			secs = timeStamp[0];
			if (Integer.parseInt(secs) <= 9) {
				secs = "0" + secs;
			}
			break;

		case 2:
			mins = timeStamp[0];
			if (Integer.parseInt(timeStamp[0]) <= 9) {
				mins = "0" + timeStamp[0];
			}

			secs = timeStamp[1];
			if (Integer.parseInt(secs) <= 9) {
				secs = "0" + secs;
			}
			break;

		case 3:
			hrs = timeStamp[0];
			if (Integer.parseInt(timeStamp[0]) <= 9) {
				mins = "0" + timeStamp[0];
			}

			mins = timeStamp[1];
			if (Integer.parseInt(timeStamp[1]) <= 9) {
				mins = "0" + timeStamp[1];
			}

			secs = timeStamp[2];
			if (Integer.parseInt(secs) <= 9) {
				secs = "0" + secs;
			}
			break;

		default:
			break;

		}

		String duration = hrs + "hrs " + mins + "mins " + secs + "secs";
		return duration;
	}

}






