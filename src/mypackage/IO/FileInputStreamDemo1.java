package mypackage.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamDemo1 {

	public static void bufferedIOStreamDemo() {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream("src/mypackage/IO/FileTest/1"));
			bos = new BufferedOutputStream(new FileOutputStream("src/mypackage/IO/FileTest/3.txt"));
			int i;
			while((i = bis.read()) != -1)
				bos.write(i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bis != null)
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(bos != null)
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static void main(String[] args) {
		//fileIOStreamTest();
		bufferedIOStreamDemo();
	}

	public static void fileIOStreamTest() {
		FileInputStream file = null;
		FileOutputStream fos = null;
		try {
			file = new FileInputStream(new File("src/mypackage/IO/FileTest/1"));
			fos = new FileOutputStream("src/mypackage/IO/FileTest/3.txt");
			int accept;
			byte[] b = new byte[1024 * 8];      // 缓冲区
			while((accept = file.read(b)) != -1)   // accept = 接受的byte长度
				fos.write(b);
			System.out.println(new String(b));  // byte[] to string
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(file != null)
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
