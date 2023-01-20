package javaprogrammingpractice.arunsachin;
/**
 *  How to check a thread is alive or not?
 * @author amaduraiveeran
 *
 */
public class Checkthread {

	public static void main(String[] args) {
		Thread trd = new Thread("thread 1");
		Thread trd2 = new Thread ("thread 2");

		trd.start();


		if(trd.isAlive()){
			System.out.println("Thread "+trd.getName()+" Is Alive");
		}else {
			System.out.println("Thread "+trd.getName()+" Is not Alive");
		}

		if(trd2.isAlive()) {
			System.out.println("Thread "+trd.getName()+" Is Alive");
		}else {
			System.out.println("Thread "+trd.getName()+" Is not Alive");
		}
	}

}
