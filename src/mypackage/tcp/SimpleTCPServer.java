package mypackage.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleTCPServer {

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(21567);
		
		Socket sock = server.accept();
		InputStream is = sock.getInputStream();
		OutputStream os = sock.getOutputStream();
		byte[] arr = new byte[4096];
		int len;
		String msg = "connected to server";
		os.write(msg.getBytes());
		len = is.read(arr);
		System.out.println(new String(arr, 0 ,len));
		sock.close();
	}

}
