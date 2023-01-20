package javaprogrammingpractice.venkat;

//How to solve deadlock using thread?
public class SolveDeadlock {
	public static void main(String[] args) {
		GFG deadlock = new GFG();
		deadlock.m1();
	}

	static class A {
		public synchronized void last() {
			System.out.println("Inside A, last() method");
		}

		public synchronized void d1(B b) {
			System.out.println("Thread1 start execution of d1() method");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println("Thread trying to call B's last() method");
			b.last();
		}
	}

	static class B {
		public void last() {
			System.out.println("Inside B, last() method");
		}

		public void d2(A a) {
			System.out.println("Thread2 start execution of d2() method");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println("Thread2  trying to call A's last method");
			a.last();
		}
	}

	static class GFG extends Thread {
		A a = new A();
		B b = new B();

		public void m1() {
			this.start();
			a.d1(b);
		}

		@Override
		public void run() {
			b.d2(a);
		}
	}
}
