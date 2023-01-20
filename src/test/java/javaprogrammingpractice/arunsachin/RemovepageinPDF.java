package javaprogrammingpractice.arunsachin;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class RemovepageinPDF {
	public static void main(String[] args) throws IOException {
		 // Loading an existing document
        File file = new File("C:\\Users\\amaduraiveeran\\Desktop\\Automationtask\\Sucide_Squad_Automation_Repo\\test-output\\SamplePdf_1.73Mb_87_Page.pdf");
        PDDocument document = PDDocument.load(file);

        int noOfPages = document.getNumberOfPages();
        System.out.println("Total number of pages:"+noOfPages);
        PDPage page = document.getPage(4);
        document.removePage(page);
        System.out.println("page removed");
        document.save("C:\\Users\\amaduraiveeran\\Desktop\\Automationtask\\Sucide_Squad_Automation_Repo\\test-output\\SamplePdf_1.73Mb_87_Page.pdf");

        document.close();
	}
}
