/*
 * 	创建标准异常对象,抛出错误
 */
package mypackage;

public class ThrowDemo {
	static void demoproc() {
		try {
			throw new NullPointerException("demo");		// 创建标准异常对象
		}
		catch (NullPointerException e) {
			System.out.println("Caught inside demoproc.");
			throw e;
		}
	}
	static void throwOne() throws IllegalAccessException {	// 由方法调用者解决throw的exception
		System.out.println("Inside throwOne.");
		throw new IllegalAccessException("demo");
	}
	
	public static void main(String[] args) {
		try {
			demoproc();
		}
		catch(NullPointerException e) {
			System.out.println("Recaught : "+e);
		}
		try {					// 自己catch throwOne的exception
			throwOne();
		} catch(IllegalAccessException e) {
			System.out.println("Caught "+e);
		}
	}

}
