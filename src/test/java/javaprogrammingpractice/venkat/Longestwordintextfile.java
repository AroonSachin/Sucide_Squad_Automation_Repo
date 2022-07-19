package javaprogrammingpractice.venkat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Longestwordintextfile {

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println(findLongestWords());
	}

	public static String findLongestWords() throws FileNotFoundException {

		String longest_word = "";
		String current;
		Scanner sc = new Scanner(new File("C:\\AutomationTask\\Sucide_Squad_Automation_Repo\\test-output\\text file"));

		while (sc.hasNext()) {
			current = sc.next();
			if (current.length() > longest_word.length()) {
				longest_word = current;
			}

		}

		return longest_word;
	}
}
