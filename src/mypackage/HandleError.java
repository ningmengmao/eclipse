package mypackage;
import java.util.Random ;

public class HandleError {

	public static void main(String[] args) {
		int a = 0, b = 0, c[] = { 1 };
		Random r = new Random();
		for(int i=0; i<32000; i++) {
			try {
				b = r.nextInt();
				c[42] = 1;
				a = 42 / b;
				
			}
			catch (ArithmeticException e) {
//				System.out.println("Division by zero.");
				System.out.println("Exception :" + e);
				a = 0;
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Array index oob : " + e);
			}
			System.out.println("a : "+a);
		}
	}

}
