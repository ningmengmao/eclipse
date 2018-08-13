/*
 *  链式异常处理
 *  多重捕获
 */
package mypackage;

public class ChainExcDemo {
	static void demoproc() {		// 链式异常处理
		NullPointerException e = new NullPointerException("top layer");  
		e.initCause(new ArithmeticException("cause"));		// 背后异常
		throw e;
	}
	public static void main(String[] args) {
		try {
			demoproc();
		} catch(NullPointerException e) {
			System.out.println("Caught : "+e);
			System.out.println("Original cause : "+e.getCause());
		}
		int a=10, b=0;
		int vals[] = { 1, 2, 3 };
		try {
		//	int result = a / b;
			vals[10] = 19;
		} catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {	// 多重捕获
			System.out.println("Exception caught: "+e);
		}
		System.out.println("After multi-catch.");
	}
	

}
