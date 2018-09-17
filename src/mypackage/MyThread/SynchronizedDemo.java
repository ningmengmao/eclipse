package mypackage.MyThread;

import java.util.Date;

public class SynchronizedDemo {

	public static void main(String[] args) throws InterruptedException {
		syntest();
	}
	public static void syntest() {
		final MyPrinter mp = new MyPrinter();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					mp.print1();
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					mp.print2();
				}
			}
		};
		t1.start();
		t2.start();
	}
}

class MyPrinter {
	public void print1() {
		synchronized (this) {      // 指定锁为this
			System.out.print("我");
			System.out.print("爱");
			System.out.print("北");
			System.out.print("京");
			System.out.print("天");
			System.out.print("安");
			System.out.print("门");
			System.out.println();				
		}
	}
	public synchronized void print2() {			// 锁为this
		System.out.print("天");
		System.out.print("安");
		System.out.print("门");
		System.out.print("上");
		System.out.print("太");
		System.out.print("阳");
		System.out.print("升");
		System.out.println();
	}
	public static synchronized void print3() {  // 锁为MyPrinter.class
		
	}
}
