/**
 *	递归
 */
package github_project_1;

class Factorial{
	long fact(int n) {
//		int result;
		if(n == 1)
			return 1;
//		result = fact(n-1)*n;
//		return result;
		return fact(n-1)*n;
	}
}

public class Recursion {

	public static void main(String[] args) {
	
		Factorial f = new Factorial();
		System.out.println(f.fact(20));
	}
}
