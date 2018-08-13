/*
 * 方法重写
 * 动态方法调度
 * 抽象类
 */
package mypackage;

abstract class Figuer {		//抽象类
	double dim1;
	double dim2;
	
	Figuer(double a, double b){
		dim1 = a;
		dim2 = b;
	}
	//抽象方法
	abstract double area();
}

class Rectangle extends Figuer {
	Rectangle(double a, double b){
		super(a,b);
	}
	// 重写
	double area() {
		System.out.println("Inside Area for Rectangle.");
		return dim1 * dim2;
	}
}

class Triangle extends Figuer {
	Triangle(double a, double b){
		super(a,b);
	}
	
	double area() {
		System.out.println("Inside Area for Triangle.");
		return dim1 * dim2 / 2;
	}
}

public class FindAreas {

	public static void main(String[] args) {
//		Figuer f = new Figuer(10, 10); 抽象类不能实例化，但是能引用子类
		Rectangle r = new Rectangle(9, 5);
		Triangle t = new Triangle(10, 5);
		Figuer figref;		//超类变量
		
		figref = r;			//引用子类
		System.out.println("Area is " + figref.area());
		figref = t;			//引用子类
		System.out.println("Area is " + figref.area());
	}

}
