package mypackage.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRWTest {

	public static void main(String[] args) throws IOException {
		//bufferedRWTest();
		other();
	}
	public static void bufferedRWTest() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("src\\mypackage\\IO\\FileTest\\1"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src\\mypackage\\IO\\FileTest\\2.txt"));
		int i;
		while((i = br.read()) != -1)
			bw.write(i);
		br.close();
		bw.close();
	}
	public static void other() throws IOException {
		FileReader fr = new FileReader("src\\mypackage\\IO\\FileTest\\1");
//		FileWriter fw = new FileWriter("src\\mypackage\\IO\\FileTest\\2.txt");
		int i;
		while((i = fr.read()) != -1)
			System.out.print((char)i);
	}
}
