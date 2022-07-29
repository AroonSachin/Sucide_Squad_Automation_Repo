package javaprogrammingpractice.arunsachin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;

// Write a Java program to read first 3 lines from a file
public class Read3lines {
	public static void main(String[] args) throws IOException {
		String line = null;
		try {
			LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(
					"C:\\Users\\amaduraiveeran\\Desktop\\Automationtask\\Sucide_Squad_Automation_Repo\\test-output\\read.txt"),
					"UTF-8"));
			while (((line = reader.readLine()) != null) && reader.getLineNumber() <= 3) {
				System.out.println(line);
			}
			reader.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("File not found:");
			e.printStackTrace();
		}
	}
}
