/*
 * 线程挂起和重启
 */
package github_project_1.MyThread;

class NewThread1 implements Runnable {
	private String name;
	Thread t;
	private boolean suspendFlag;
	
	NewThread1(String n){
		name = n;
		t = new Thread(this, name);
		System.out.println("New thread: "+n);
		suspendFlag = false;
		t.start();
	}
	public void run() {
		try {
			for(int i=0; i<15; i++) {
				System.out.println(name+": "+i);
				Thread.sleep(200);
				synchronized(this) {
					while(suspendFlag)
						this.wait();
				}
			}
		} catch(InterruptedException e) {
			System.out.println(name+" interrupted.");
		}
		System.out.println(name+" exiting.");
	}
	synchronized void mysuspend() {
		suspendFlag = true;
	}
	synchronized void myresume() {
		suspendFlag = false;
		notifyAll();
	}
}
	
public class SuspendResume {

	public static void main(String[] args) {
		NewThread1 ob1 = new NewThread1("Thread One");
		NewThread1 ob2 = new NewThread1("Thread Two");
		try {
			Thread.sleep(1000);
			ob1.mysuspend();
			System.out.println("Suspend Thread One");
			Thread.sleep(1000);
			ob1.myresume();
			System.out.println("Resuming Thread One");
			ob2.mysuspend();
			System.out.println("Suspend Thread Two");
			Thread.sleep(1000);
			ob2.myresume();
			System.out.println("Resuming Thread Two");
		} catch(InterruptedException e) {
			System.out.println("Main interrupted.");
		}
		try {
			System.out.println("Waiting for threads to finish.");
			ob1.t.join();
			ob2.t.join();
		} catch(InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		System.out.println("Main thread exiting.");
	}
}
