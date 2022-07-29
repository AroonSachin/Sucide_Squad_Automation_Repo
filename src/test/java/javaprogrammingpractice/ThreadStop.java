package javaprogrammingpractice;

public class ThreadStop {

	public static void main(String[] args) {
		Thread t1 = new Thread ("Thread A");
		Thread t2 = new Thread ("Thread B");
		t1.start();
		t2.start();
		if(t1.isAlive())
		{
			System.out.println("Thread t1 is alive");
		}
		else
		{
			System.out.println("Thread t1 is stopped");
		}
		
		t2.stop();
		if(t2.isAlive())
		{
			System.out.println("Thread t2 is alive");
		}
		else
		{
			System.out.println("Thread t2 is stopped");
		}
		
		}

}
