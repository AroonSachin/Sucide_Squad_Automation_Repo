package javaprogrammingpractice.arunsachin;

import java.io.File;

public class Checkfile {
	public static void main(String[] args) {
		System.out.println(new File("C:\\Users\\amaduraiveeran\\.m2\\repository/org/aspectj/aspectjweaver/1.9.6/aspectjweaver-1.9.6.jar").exists());

		System.out.println(new File("C:\\Users\\amaduraiveeran\\.m2\\repository/org/aspectj/aspectjweaver/1.9.6/aspectjweaver-1.9.6.jar").canRead());
	}

}
