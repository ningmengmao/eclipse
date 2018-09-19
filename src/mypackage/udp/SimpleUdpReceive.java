package mypackage.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class SimpleUdpReceive {

	public static void main(String[] args) throws IOException {
		receive();
	}

	public static void receive() throws SocketException, IOException {
		DatagramSocket s = new DatagramSocket(21568);
		while(true) {
			DatagramPacket data = new DatagramPacket(new byte[4096], 4096);
			s.receive(data);
			byte[] arr ;
			arr = data.getData();
			int len = data.getLength();
			String str = new String(arr, 0 , len);
			if("quit".equals(str)) {
				System.out.println("server stop");
				break;
			}
			String ip = data.getAddress().getHostAddress();
			int port = data.getPort();
			System.out.println("from " + ip + ":" + port + " " +str);
		}
		s.close();
	}

}
