/*
 * 竞态
 * 同步语句
 */
package github_project_1.MyThread;
class Callme {
//	void call(String msg) {   竞态的
	synchronized void call(String msg) {   // 同步的
		try {
			System.out.print("[ "+msg);
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println("Interrupted.");
		}
		System.out.println("]");
	}
}

class Caller implements Runnable {
	Callme target;
	String msg;
	Thread t;
	
	Caller(Callme targ, String m) {
		target = targ;
		msg = m;
		t = new Thread(this);
		t.start();
	}
	public void run() {
		// synchronized(target){    // 假如target对象的call方法没有synchronized修饰符,
		//		target.call(msg);   // 这样也能将call声明为同步语句
		// }
		target.call(msg);
	}
}
public class Synch {

	public static void main(String[] args) {
		Callme target = new Callme();
		Caller ob1 = new Caller(target, "Hello");
		Caller ob2 = new Caller(target, "Synchronized");
		Caller ob3 = new Caller(target, "World");
		
		try {
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		} catch(InterruptedException e) {
			System.out.println("Main interrupted.");
		}
	}

}
