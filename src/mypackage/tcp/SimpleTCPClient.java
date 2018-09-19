package mypackage.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SimpleTCPClient {

	public static void main(String[] args) throws IOException {
		Socket sock = new Socket("127.0.0.1", 21567);
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		PrintStream ps = new PrintStream(sock.getOutputStream());
		String msg = "hello server";
		String recv ;
		ps.println(msg);
		System.out.println("send : " + msg);
		recv = bfr.readLine();
		System.out.println("recvive : " + recv);
		sock.close();
	}
}
