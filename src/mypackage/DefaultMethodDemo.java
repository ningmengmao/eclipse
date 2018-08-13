/*
 * 带默认方法的接口
 */
package mypackage;
import java.util.Random;

class MyIFImp implements MyIF {
	// 未重写getString，使用默认的getString
	public int getNumber() {
		// 返回100以内的随机数，不包括100
		Random r = new Random();
		return r.nextInt(100);	
	}
}

class MyIFImp2 implements MyIF {
	public int getNumber() {
		Random r = new Random();
		return r.nextInt(50);	
	}
	public String getString() {
		return "This is a different string.";
	}
}

class DefaultMethodDemo {
	public static void  main(String args[]) {
		
		MyIFImp ob = new MyIFImp();
		System.out.println(ob.getNumber());
		System.out.println(ob.getString());
	}
}
