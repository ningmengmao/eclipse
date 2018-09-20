package mypackage.reflect;

public class Person {
	public String name;
	private int age;
	
	public Person() {
		name = null;
		age = -1;
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void eat() {
		System.out.println(name + "吃了一顿饭");
	}
	public void eat(String food) {
		System.out.println(name + "吃了" + food);
	}
	@SuppressWarnings("unused")
	private void getAge() {
		System.out.println(age);
	}
	@Override
	public String toString() {
		return "Person -> name: " + name + " age: " + age ;
	}
	public void run() {
		System.out.println("好好学习，天天向上");
	}
}
