package mypackage.udp;

import java.io.IOException;


public class SimpleUdpRS {

	public static void main(String[] args) throws InterruptedException {
		Thread s = new Thread("Send") {
			@Override
			public void run() {
				try {
					SimpleUdpSend.send();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		Thread r = new Thread("Recieve") {
			@Override
			public void run() {
				try {
					SimpleUdpReceive.receive();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		r.start();
		Thread.sleep(1000);
		s.start();	
	}

}
