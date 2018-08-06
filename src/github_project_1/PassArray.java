/*
 *  静态方法，不需要类的对象就直接调用
 *  可变长度参数
 */
package github_project_1;

public class PassArray {
	static void vaTest(String msg, int ... v) {	 
		//可变长度参数 ，三个句点 （...）标识，如果有常规参数，那么可变参数必须声明在最后
		//最多只能有一个可变长度参数(如果有，无法和另外一个区分)
		//可以重载采用可变长度参数的方法
		System.out.print(msg + v.length + " Contents: ");
		for(int x : v)
			System.out.print(x + " ");
		System.out.println();
	}
	
	static void vaTest(int ... v) {	 
		System.out.print("Number of args: " + v.length + " Contents: ");
		for(int x : v)
			System.out.print(x + " ");
		System.out.println();
	}
	
	static void vaTest(boolean ... v) {	 
		System.out.print("Number of args: " + v.length + " Contents: ");
		for(boolean x : v)			//注意类型
			System.out.print(x + " ");
		System.out.println();
	}
	
	static void vaTest(String ... v) {	 
		System.out.print("Number of args: " + v.length + " Contents: ");
		for(String x : v)			//注意类型
			System.out.print(x + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
//		int n1[] = { 10 };
//		int n2[] = {1, 2, 3};
//		int n3[] = { };
	
		vaTest("first, ", 10);
		vaTest("second, ",1,2,3);
	//	vaTest("thrid, "); vaTest(String ... v) 和 vaTest(String msg, int ... v) 模糊，报错。必须使用不同的方法名
	}
}
