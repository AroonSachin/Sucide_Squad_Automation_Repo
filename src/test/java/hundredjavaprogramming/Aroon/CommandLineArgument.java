package hundredjavaprogramming.Aroon;
/**
 * @question Command line argument
 * @author aroon
 *
 */
public class CommandLineArgument {
	
	public static void commandLine(String name) {
		System.out.println("Hi "+name+"Hope you Ran the program from command prompt.");
	}
	
	public static void main(String[] args) {
		commandLine(args[0]);
	}
}
