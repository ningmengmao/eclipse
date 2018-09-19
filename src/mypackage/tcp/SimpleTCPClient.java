package mypackage.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleTCPClient {

	public static void main(String[] args) throws IOException {
		Socket sock = new Socket("127.0.0.1", 21567);
		
		InputStream is = sock.getInputStream();
		OutputStream os = sock.getOutputStream();
		int len;
		byte[] arr = new byte[4096];
		len = is.read(arr);
		System.out.println(new String(arr, 0 ,len));
		os.write("client say something".getBytes());
		sock.close();
	}

}
