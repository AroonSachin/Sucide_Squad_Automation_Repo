package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import commonuseractions.CommonActionMethods;

public class Mail extends CommonActionMethods {

	public static void sendReport(String reportPath) throws IOException {
		// authentication info
		final String username = "arunsachin.m@tridentsqa.com";
		final String password = "gnjiomtwfcvsxivk";
		String fromEmail = "arunsachin.m@tridentsqa.com";
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
			 msg.addRecipients(Message.RecipientType.CC,
			 "vinoth.velayutham@tridentsqa.com,vinoth.raj@tridentsqa.com");

			DateFormat dateFormat = new SimpleDateFormat("dd/MMM/YYYY");
			Date date = new Date();

			if (mailFlag) {
				msg.setSubject("Alert Automation Test Execution Failure " + dateFormat.format(date));
			} else {
				msg.setSubject("Sucide Squad Test Automation Report " + dateFormat.format(date));
			}

			Multipart emailContent = new MimeMultipart();

			// Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			String htmlBody;
			if (mailFlag) {
				File file = new File(FailedScreenShotdestination.get());
				htmlBody = "<h4>Hello Team,</h4><p><b>Alert!!!</b> The following scenario \"<b>"
						+ getScenarioDescription() + "</b>\" has failed due to <b>" + getScenarioComments()
						+ "</b></p><p>Please find the screenshot for the current failed scenario</p><img src=\"cid:image\"alt=\"Barcode\" width=\"350\" height=\"250\" align=\"left\">";
				// first part (the html)
				BodyPart messageBodyPart = new MimeBodyPart();

				messageBodyPart.setContent(htmlBody, "text/html");
				// add it
				MimeMultipart multipart = new MimeMultipart("related");
				multipart.addBodyPart(messageBodyPart);

				// second part (the image)
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(file);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setHeader("Content-ID", "<image>");

				// add image to the multipart
				multipart.addBodyPart(messageBodyPart);

				// put everything together
				msg.setContent(multipart);
			} else {
				htmlBody = MailBody.emailBodyCreator(testDuration(), "Sucide Squad");
				// Email body message creation
				StringBuilder sb = new StringBuilder();
				sb.append(htmlBody);
				textBodyPart.setContent(sb.toString(), "text/html");
				if (extentreport != null) {
					File folder = new File(System.getProperty("user.dir") + reportPath);

					// Attachment body part.

					File attachFiles = new File(System.getProperty("user.dir") +reportPath);

					attachFile(attachFiles, emailContent, new MimeBodyPart());
				}
				// Attach body parts
				emailContent.addBodyPart(textBodyPart);

				// Attach multipart to message
				msg.setContent(emailContent);

			}
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
