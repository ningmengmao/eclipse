package mypackage.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;


public class SimpleUdpSend {

	public static void main(String[] args) throws IOException {
		send();
	}

	public static void send() throws SocketException, UnknownHostException, IOException {
		Scanner sc = new Scanner(System.in);
		DatagramSocket s = new DatagramSocket();   //随机端口
		while(true) {
			String str = sc.nextLine();
			DatagramPacket p = new DatagramPacket(str.getBytes(), 
					str.getBytes().length, InetAddress.getByName("127.0.0.1"), 21568);
			s.send(p);
			if("quit".equals(str)) {
				System.out.println("Client close");
				break;
			}
		}
		s.close();
	}

}
