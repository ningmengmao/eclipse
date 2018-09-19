package mypackage.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class UploadServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(21567);
		
		while(true) {
			final Socket sock = server.accept();
			new Thread() {
				@Override
				public void run() {
					try {
						String path;
						BufferedInputStream bis = new BufferedInputStream(sock.getInputStream());
						PrintStream ps = new PrintStream(sock.getOutputStream());
						byte[] arr = new byte[8192];
						int leng;
						leng = bis.read(arr);
						path = new String(arr, 0, leng).trim();
						File file = new File("src/" + path);					
						if(file.exists()) {
							ps.println("exist");
							System.out.println(path + " 已存在");
						}
						else {
							ps.println("NO");
							System.out.println("准备接收 " + path);
							// 字节流能写全部类型的数据
							BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(file));
							int len;
							while((len = bis.read()) != -1)
								bw.write(len);
							System.out.println("接收" + path + "完成");
							bw.close();
						}
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
			}.start();;
		}
	}

}
