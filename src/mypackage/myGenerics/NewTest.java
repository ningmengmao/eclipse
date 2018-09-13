package mypackage.myGenerics;

import java.util.ArrayList;
import java.util.List;

public class NewTest {

	
	public static void test() {
		
	}
	public static void main(String[] args) {
		test();
	}
}

class Person<T> {
	private int id;
	private String name;
	private int age;
	private String sex;
	private T t;
	public Person() {
		this.id = -1;
		this.name = null;
		this.age = -1;
		this.sex = "man";
		this.t = null;
	}
	public Person(int id, String name, int age, String sex, T t) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.t = t;
	}
	public T getT() {
		return t;
	}
	public <U> void printU(U u) {
		System.out.println(u);
	}
}

class Student extends Person<String>{	}
class Teacher<T> extends Person<T>{	 }
