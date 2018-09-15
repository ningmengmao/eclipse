package mypackage.IO;

import java.io.IOException;
import java.io.InputStream;

public class SystemInOut {

	public static void main(String[] args) throws IOException {
		InputStream ins = System.in;
		int x = ins.read();
		ins.close();
		System.out.println(x);
	}

}
