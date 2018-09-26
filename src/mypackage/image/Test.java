package mypackage.image;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
	public static void main(String...args) throws FileNotFoundException, IOException, InterruptedException {
		for(int i=0; i<100; i++) {
			VerifyCode.output(new VerifyCode().getImage(), 
				new FileOutputStream("src/mypackage/image/2.jpg"));
				Thread.sleep(5000);
		}
	}
}
