package mypackage;

//public class Exc0 {
//
//	public static void main(String[] args) {
//		int d = 0;
//		int a = 42 / d;
//	}
//}
public class Exc0 {
//	static void subroutine() {
//		int d = 0;
//		int a = 10 / d;
//	}
	public static void main(String args[]) {
		int d, a;
		try {
			d = 0;
			a = 42 / d;
			System.out.println("This will not be printed.");
		}
		catch (ArithmeticException e) {
			System.out.println("Division by zero.");
			a = 0;
		}
		System.out.println("after catch statement, a = "+a);
	}
}