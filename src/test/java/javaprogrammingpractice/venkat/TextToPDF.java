package javaprogrammingpractice.venkat;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class TextToPDF {
	public static void main(String[] args) throws IOException {
		PDDocument doc = new PDDocument();
		PDPage page = new PDPage();
		doc.addPage(page);
		PDPageContentStream stream = new PDPageContentStream(doc, page);
		PDFont font = PDType1Font.HELVETICA;
		stream.setFont(font, 14);
		stream.beginText();
		stream.moveTextPositionByAmount(0, 780);
		stream.drawString("Hello everyone");
		stream.drawString("its a great to see u all ");
		stream.endText();
		stream.close();
		doc.save("e:/myfile.pdf");
		doc.close();
	}

}
