package javaprogrammingpractice.venkat;

public class Removenon_alphanumeric {

	public static void main(String[] args) {

		String remove ="@@@ it trident 2205 #$#$#$%%";
		remove = remove.replaceAll("[a-zA-Z0-9]", "");
		System.out.println(remove);
		String removenonalphanumeric1 = "###$$$^&* trident !!!!!sqa";
		removenonalphanumeric1 = removenonalphanumeric1.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(removenonalphanumeric1);

	}

}