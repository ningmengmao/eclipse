/*
 * 建立线程
 * 如果不重写Thread类的方法(run除外),推荐使用Runnable接口创建线程
 */
package mypackage.MyThread;

class NewThread implements Runnable {		// 实现Runnalbe接口方法建立线程
	Thread t;
	NewThread() {
		t = new Thread(this, "Demo Thread"); // 建立Thread对象,调用this对象的run()
		System.out.println("Child thread: "+t);
		t.start();			// 线程启动
	}
	public void run() {			// 线程运行代码
		try {
			for(int n=5; n>0; n--) {
				System.out.println("Child thread: "+n);
				Thread.sleep(500);
			}
		}
		catch (InterruptedException e) {
			System.out.println("Chlid thread interrupted.");
		}
		System.out.println("Exitin child thread.");
	}
}

class NewThread2 extends Thread {		// 扩展Thread类
	NewThread2(){
		super("Demo Thread2");			// 线程名
		System.out.println("Child thread2: "+ this);
		this.start();
	}
	public void run() {
		try {
			for(int n=5; n>0; n--) {
				System.out.println("Child Thread2: "+n);
				Thread.sleep(250);
			}
		} catch(InterruptedException e) {
			System.out.println("Chlid thread2 interrupted.");
		}
		System.out.println("Exitin child thread2.");
	}
}

public class ThreadDemo {

	public static void main(String[] args) {
		new NewThread();	// 建立线程
		new NewThread2();   
		try {
			for(int i=5; i>0; i--) {
				System.out.println("Main thread: "+i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		System.out.println("Main thread exiting.");
	}

}
