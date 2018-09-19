package mypackage.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleTCPServer {

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(21567);
		while(true) {
			final Socket sock = server.accept();

			//		InputStream is = sock.getInputStream();
			//		OutputStream os = sock.getOutputStream();
			new Thread() {
				@Override
				public void run() {
					try {
						BufferedReader bfr = new BufferedReader(new InputStreamReader(sock.getInputStream()));
						PrintStream ps = new PrintStream(sock.getOutputStream());
						String msg = "connected to server";
						String recv ;
						recv = bfr.readLine();
						System.out.println("recviev : " + recv);
						ps.println(msg);
						System.out.println("send : " + msg);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							sock.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			};
		}
	}

}
