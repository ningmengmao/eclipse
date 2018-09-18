package mypackage.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class SimpleUdpSend {

	public static void main(String[] args) throws IOException {
		String str = "hello world";
		DatagramSocket s = new DatagramSocket();   //随机端口
		DatagramPacket p = new DatagramPacket(str.getBytes(), 
				str.getBytes().length, InetAddress.getByName("127.0.0.1"), 21568);
		s.send(p);
		s.close();
	}

}
