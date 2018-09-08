package mypackage.IO;

import java.io.File;
import java.io.IOException;

public class FileTestDemo {

	public static void main(String[] args) {
		File f = new File("src/mypackage/IO/FileTest");
//		System.out.println(f.mkdirs());
//		System.out.println(f.getAbsolutePath());
		File f1 = new File(f, "1");
		File f2 = new File(f, "2");
		File f3 = new File(f, "3.txt");
		try {
			f1.createNewFile();
			f2.mkdir();
			f3.createNewFile();
		} catch (IOException e) {
			System.out.println(e);
		}
		File[] dir = f.listFiles();
		String[] list = f.list(DirFilter.filter(".+?"));
		for (File subFile : dir)
			if(subFile.isFile())
				System.out.println(subFile.getName() + " is file");
			else
				System.out.println(subFile.getName() + " is directory");
		for (String l : list)
			System.out.println(l);
		
	}

}
