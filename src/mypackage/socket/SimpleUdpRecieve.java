package mypackage.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SimpleUdpRecieve {

	public static void main(String[] args) throws IOException {
		DatagramSocket s = new DatagramSocket(21568);
		DatagramPacket data = new DatagramPacket(new byte[4096], 4096);
		s.receive(data);
		byte[] arr ;
		arr = data.getData();
		int len = data.getLength();
		s.close();
		System.out.println(new String(arr, 0 , len));
	}

}
