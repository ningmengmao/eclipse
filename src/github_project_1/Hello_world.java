/**
 * 
 */
package github_project_1;

/**
 * @author ningmengmao
 *
 */

class Box {

	double width;
	double height;
	double depth;
	
	Box(){
		System.out.println("Constructing Box");
		this.width = 10;
		this.height = 10;
		this.depth = 10;
	}
	
	Box(double w, double h, double d){
		this.width = w;
		this.height = h;
		this.depth = d;
	}
	
	void volume() {
		System.out.print("Volume is ");
		System.out.println(this.width*this.height*this.depth);
	}
	
	protected void finalize() {
		// 垃圾回收,对象销毁前执行,如释放句柄或文件描述符
		//System.out.println("running finalize");
	}
}



class Overload {
	void test() {
		System.out.println("no parameters.");
	}
	
	void test(int a) {
		System.out.println("one int parameters.");
	}
	
	void test(int a, int b) {
		System.out.println("two int parameters.");
	}
	
	void test(double a) {
		System.out.println("double parameters.");
	}
}

public class Hello_world {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	/*
	*	int id[] = new int[10];
	*	for(int i = 0 ; i < 10; i++)
	*		id[i] = i;
	*	for(int i : id)
	*		System.out.println(i);
	*/
		
	/*
	*	int nums[][] = new int[5][10];
	*	for(int i=0; i<5; i++)
	*		for(int j=0; j<10; j++)
	*			nums[i][j] = i + j;
	*	for(int x[]:nums) {
	*		for(int y:x)
	*			System.out.print(y+" ");
	*		System.out.println();
	*	}
	*/
		Box mybox1 = new Box();
		Box mybox2 = new Box(5,5,5);
	//	mybox1.width = 2;
	//	System.out.println(mybox2.width);
	//	mybox2.width = 3;
	//	System.out.println(mybox1.width);
	//	mybox1.height = 4;
	//	mybox1.depth = 5;
		mybox1.volume();
		mybox2.volume();
		Overload ob = new Overload();
		ob.test();
		ob.test(1);
		ob.test(1,2);
		ob.test(1.234);
		
	}
}


