package mypackage.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UploadClient {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入文件路径");
		String path;
		String filename;
		while(true) {
			path = sc.nextLine();
			File f = new File(path);
			filename = f.getName();
			if(!f.exists()) 
				System.out.println("路径错误");
			else if(f.isDirectory())
				System.out.println("您输入的是文件夹路径");
			else 
				break;
		}
		Socket sock = new Socket("127.0.0.1", 21567);
		BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		PrintStream ps = new PrintStream(sock.getOutputStream());
		String recv ;
		ps.println(filename);
		recv = br.readLine();
		if("exist".equals(recv)) {
			System.out.println(filename + " 文件已存在");
			sock.close();
		}
		else {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
			byte[] arr = new byte[4096];
			int len;
			while((len = bis.read(arr)) != -1)
				ps.write(arr, 0, len);
			System.out.println(br.readLine());
			bis.close();
			sock.close();
		}
	}

}
