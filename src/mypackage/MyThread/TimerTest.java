package mypackage.MyThread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class TimerTest {
	public static void main(String[] args) throws InterruptedException {
		Timer t = new Timer("定时器线程");
		t.schedule(new SubTimerTask(), new Date(1537169600000L),3000);
		while(true) {
			Thread.sleep(1000);
			System.out.println(new Date());
		}
		
	}
}

class SubTimerTask extends TimerTask {
	@Override
	public void run() {	
		System.out.println(new Date() +" do something");
	}
	
}