package github_project_1;

class Outer {
	int out_x = 100;
	
	void test() {
		Inner inner = new Inner();
		inner.display();
	}
	
	class Inner{
		void display() {
			System.out.println("display: outer_x = "+ out_x);
		}
	}
}

public class InnerClassDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Outer outer = new Outer();
		outer.test();
	}

}
