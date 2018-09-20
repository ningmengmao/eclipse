package mypackage.IO;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FindFiles {

	static ArrayList<String> filename = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path;
		while(true) {
			System.out.println("请输入文件夹路径");
			path = sc.nextLine();
			File dir = new File(path);
			if(!dir.exists())
				System.out.println("文件夹不存在");
			else if(dir.isFile())
				System.out.println("输入的是文件路径");
			else 
				break;
		}
		ArrayList<String> fn = FindFiles.getFilesNum(new File(path));
		System.out.println(fn);
		System.out.println(fn.size());
	}
	
	public static ArrayList<String> getFilesNum(File dir) {
		File[] list = dir.listFiles();
		for(File f : list) {
			if(f.isDirectory())
				getFilesNum(f);
			else 
				filename.add(f.getName());
		}
		return filename;
	}	
}
