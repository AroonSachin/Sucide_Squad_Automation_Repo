package hundredjavaprogramming.Aroon;

public class CommandLineArgument {
	public static void commandLine(String name) {
		System.out.println("Hi "+name+"Hope you Ran the program from command prompt.");
	}
	
	public static void main(String[] args) {
		commandLine(args[0]);
	}
}
