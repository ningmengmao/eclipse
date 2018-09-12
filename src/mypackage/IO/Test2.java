package mypackage.IO;

import java.io.File;
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
	
	public static void main(String[] args) {
		File f = getDirFile();
		listJavaFile(f);
		
		
	}

}
