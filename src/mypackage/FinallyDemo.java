/*
 *  finally 语句的使用
 */
package mypackage;

public class FinallyDemo {
	static void procA() {
		try {
			System.out.println("Inside procA.");
			throw new RuntimeException("demo");
		} //catch(RuntimeException e) {	
		//}
		finally {
			System.out.println("procA's finally.");     // throw后执行
		}
	}
	static void procB() {
		try {
			System.out.println("Inside procB.");
			return ;
		}
		finally {
			System.out.println("procB's finally.");		//回到main之前执行
		}
	}
	static void procC() {
		try {
			System.out.println("Inside procC.");
		}
		finally {
			System.out.println("procC's finally.");		
		}
	}
	
	public static void main(String[] args) {
		try {
			procA();
		}
		catch(RuntimeException e) {
			System.out.println("Exception caught");
		}
		procB();
		procC();
	}

}
