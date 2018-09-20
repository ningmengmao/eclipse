package mypackage.DesignPatterns;

/**
 * 单例设计模式
 * 类在内存内只有一个对象(构造函数私有)，内部定义一个私有对象
 *
 */
public class SingletonPattern {
	private static SingletonPattern s = new SingletonPattern() ;
	
	private SingletonPattern() {
	}	
	/*
	* do something
	*/
	public static SingletonPattern getSingletonPattern() {
		return s;
	}
	public static void main(String... args) {
		SingletonPattern s = SingletonPattern.getSingletonPattern();
	}
}
