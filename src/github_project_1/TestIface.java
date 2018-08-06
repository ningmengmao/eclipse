/*
 * 接口 IntStack 内的方法实现 
 */

package github_project_1;

class Client implements Callback {
	public void callback(int p) {
		System.out.println("callback called with " + p);
	}
	
	void nonIfaceMeth() {
		System.out.println("Classes that implement interfaces "+ 
							"may also define other members, too.");
	}
}

class AnotherClient implements Callback {
	public void callback(int p) {
		System.out.println("Another version of callback");
		System.out.println("p squared is "+(p*p));
	}
}

public class TestIface {
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Callback c = new Client();
		c.callback(42);
//		AnotherClient ob = new AnotherClient();
//		c = ob;
		c = new AnotherClient();
		c.callback(42);
	}
}
