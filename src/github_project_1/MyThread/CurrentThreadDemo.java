package github_project_1.MyThread;

public class CurrentThreadDemo {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();  // 获取主线程
		System.out.println("Current thread: "+t);
		t.setName("MyThread");
		System.out.println("After name change: "+t);
		try {
			for(int n=5; n>0; n--) {
				System.out.println(n);
				Thread.sleep(1000);
			}
		} catch(InterruptedException e) {
				System.out.println("Main thread interrupted");
		}
	}
}
