package mypackage.MyThread;

class MyThreadChild extends Thread {
	private int x;
	public MyThreadChild(int x) {
		this.x = x;
	}
	public int getX() {
		return this.x;
	}
	@Override
	public void run() {
		for (int i=0; i<1000; i++)
			x += 1;
//			x += x;  输出出错！？？
	}
}

class MyRunnable implements Runnable {
	private int x;
	public MyRunnable(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	@Override 
	public void run() {
		x += 1;
	}
	
}
public class ThreadDemo1 {

	public static void main(String[] args) throws InterruptedException {
		MyThreadChild mtc = new MyThreadChild(10);
		MyRunnable mr = new MyRunnable(10);
		Thread t = new Thread(mr);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0 ; i<1000; i++)
					System.out.println("in thread t1");
			}
		});
		Thread t2 = new Thread("进程1") {
			@Override
			public void run() {
				System.out.print(getName() + " running");
			}
		};
		t2.start();
		t1.start();
		t.start();
		mtc.start();
//		System.out.println(mtc.getX() + " " + mr.getX());
	}

}
