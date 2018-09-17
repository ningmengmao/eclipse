package mypackage.MyThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	private  ReentrantLock rtl = new ReentrantLock();
	private static int flag = 3;
	Condition c1 = rtl.newCondition();
	Condition c3 = rtl.newCondition();
	Condition c2 = rtl.newCondition();
	public void print4() throws InterruptedException {
		rtl.lock();
		while(flag !=3)
			c1.await();
		System.out.println("in print4");
		flag = 4;
		c2.signal();
		rtl.unlock();
	}
	public void print5() throws InterruptedException {
		rtl.lock();
		while(flag !=4)
			c2.await();
		System.out.println("in print5");
		flag = 5;
		c3.signal();
		rtl.unlock();
	}	
	public void print6() throws InterruptedException {
		rtl.lock();
		while(flag !=5)
			c3.await();
		System.out.println("in print6");
		flag = 3;
		c1.signal();
		rtl.unlock();
	}
	
	
	public static void main(String[] args) {
//		waitAndNotify();		
		final ReentrantLockDemo rtld = new ReentrantLockDemo();
		Thread t1 = new Thread() {
			@Override
			public void run(){
					try {
						for(int i=0;i<10;i++)
						rtld.print4();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run(){
					try {
						for(int i=0;i<10;i++)
						rtld.print5();
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
			}
		};
		Thread t3 = new Thread() {
			@Override
			public void run(){
					try {
						for(int i=0;i<10;i++)
						rtld.print6();
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
			}
		};
		t1.start();
		t2.start();
		t3.start();
	}
	
	public static void waitAndNotify() {
		ReentrantLockDemo rtld = new ReentrantLockDemo();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					for(int i=0; i<1000;i++)
						rtld.print1();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					for(int i=0; i<1000;i++)
						rtld.print2();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		};
		Thread t3 = new Thread() {
			@Override
			public void run() {
				try {
					for(int i=0; i<1000;i++)
						rtld.print3();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		};
		t1.start();
		t2.start();
		t3.start();
	}
	
	public void print1() throws InterruptedException {
		synchronized (this) {
			while(flag != 0)
				this.wait();
			System.out.println("in print1");
			flag = 1;
			this.notifyAll();							

		}
	}
	public void print2() throws InterruptedException {
		synchronized (this) {
			while(flag != 1) 
				this.wait();
			System.out.println("in print2");
			flag = 2;
			this.notifyAll();			

		}
	}
	public void print3() throws InterruptedException {
		synchronized (this) {
			while(flag !=2)
				this.wait();
			System.out.println("in print3");
			flag = 0;
			this.notifyAll();							
		}
	}
}
