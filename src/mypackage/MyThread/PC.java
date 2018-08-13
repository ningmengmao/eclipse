/*
 * 线程间通信
 */
package mypackage.MyThread;

class Q {
	private int n;
	private boolean valueSet = false ;
	synchronized int get() {
		while(!valueSet)
			try {
				wait();
			} catch(InterruptedException e) {
				System.out.println("InterruptedException Caught.");
			}
		System.out.println("Got: "+n);
		valueSet = false;
		notifyAll();
		return n;
	}
	synchronized void put(int i) {
		while(valueSet)
			try {
				wait();
			} catch(InterruptedException e) {
				System.out.println("InterruptedException Caught.");
			}
		n = i;
		System.out.println("Put: "+i);
		valueSet = true;
		notifyAll();
	}
}

class Producer implements Runnable {
	Q q;
	Producer(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();;
	}
	public void run() {
		for(int i=0;;) {
			q.put(i++);
		}
	}
}
class Consumer implements Runnable {
	Q q;
	Consumer(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}
	public void run() {
		while(true) {
			q.get();
		}
	}
}
public class PC {

	public static void main(String[] args) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
	}

}
