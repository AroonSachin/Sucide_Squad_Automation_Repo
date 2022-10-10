package javaprogrammingpractice.sowmya;

import java.io.File;

public class FileReader {

	public static void main(String[] args) {
		//create file object enter the path of
     //the file for which size is to be found
    File file = new File("C:\\Users\\svenkateshwaran\\Desktop\\Automation_tasks\\Sucide_Squad_Automation_Repo\\test-output\\Files\\Selenium (6).txt");
    if (file.exists())
    {
        double bytes = file.length();
        double kilobytes = (bytes / 1024);

        // converting file size to bytes to kb
        double megabytes = (kilobytes / 1024);

        // converting file size from lb to mb
        double gigabytes = (megabytes / 1024);

        System.out.println("bytes : " + bytes);
        System.out.println("kilobytes : " + kilobytes);
        System.out.println("megabytes : " + megabytes);
    }
    else
    {
        System.out.println("File does not exists!");
    }
}
}


