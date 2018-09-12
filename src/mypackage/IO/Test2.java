package mypackage.IO;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
	
//	private static ArrayList<File> r = new ArrayList<>();
	
	public static void listJavaFile(File f) {
		File[] l = f.listFiles();
		for (File sub : l) {
			if (sub.isDirectory())
				listJavaFile(sub);
			else
				if(sub.getName().endsWith(".java"))
					System.out.println(sub.getName());
		}
	}
	public static File getDirFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a file path");
		String path = null;
		while(true) {
			path = sc.nextLine();
			if(!(new File(path).exists())) {
				System.out.println("path not exists");
			}else if(new File(path).isFile())
				System.out.println("Please input a dirpath");
			else
				break;
		}
		sc.close();
		return new File(path);
	}
	public static void gbkToUtf8() throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("src/mypackage/IO/FileTest/笔记.txt"), "GBK");
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src/mypackage/IO/FileTest/4"), "UTF-8");
		int i;
		while((i = isr.read()) != -1)
			osw.write(i);
		isr.close();
		osw.close();
		
	}
	public static void sequenceInputStreamTest() throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/mypackage/IO/FileTest/1"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i;
		while ((i = bis.read()) != -1)
			baos.write(i);
		bis.close();
		baos.close();
		System.out.println(baos);
	}
	public static void ObjectIOStream() throws IOException, ClassNotFoundException {
		ArrayList<Abcde> arr = new ArrayList<>();
		for (int i=0; i<5; i++)
			arr.add(new Abcde());
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/mypackage/IO/FileTest/5"));
		oos.writeObject(arr);
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/mypackage/IO/FileTest/5"));
		@SuppressWarnings("unchecked")
		ArrayList<Abcde> arr1 = (ArrayList<Abcde>) ois.readObject();
		ois.close();
		for(Abcde a : arr1)
			System.out.println(a);
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		File f = getDirFile();
//		listJavaFile(f);
//		gbkToUtf8();
//		sequenceInputStreamTest();
		ObjectIOStream();
	}
}

class Abcde implements Serializable {
	private static int count = 1;
	private final int id = count++ ;
	@Override
	public String toString() {
		return "id = " + id ; 
	}
}
