package mypackage.myGenerics;

public class NewTest {

	public static void main(String[] args) {
		Foo<Coffee> f = new Foo<>(new Coffee());
		f.f();	
		System.out.println(	f.getClass().getName());
	}
}

class Foo<T> {
	T var;
	Foo(T t){
		this.var = t;
	}
	 void f() {
		System.out.println(var.getClass().getName());
	}
}