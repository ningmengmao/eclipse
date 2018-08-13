package mypackage.CodeJava;

class A {
	int i;
	static void printSomething() {
		System.out.println("in A");
	}
	A(int i){
		this.i = i;
	}
	A(){
		i = -1;
	}
	public int getNum() {
		return i;
	}
}

class B extends A {
	int b;
	static void printSomething() {
		System.out.println("in B");
	}
	B(int a, int b){
		super(a);
		this.b = b;
	}
	B(){
		super();
		b = -1;
	}
	public int getNum() {
		return this.i + this.b;
	}
}

public class PolymorphismTest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		A a = new B();
		System.out.println(a.i);
//		System.out.println(a.b); wrong
		a.printSomething();
		System.out.println(a.getClass().getName());
		System.out.println(a.getNum());
	}

}
