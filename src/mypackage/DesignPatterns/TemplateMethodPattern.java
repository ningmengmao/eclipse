package mypackage.DesignPatterns;

/**
 * 定义一个方法骨架，具体的方法由子类实现，减少代码重复
 */

public class TemplateMethodPattern {
	public static void main(String... args) {
		System.out.println(new SubGetTime().getTime());
	}
}

abstract class GetTime {
	/**
	 * 固定的模板，子类要自己实现dosomething
	 */
	public final long getTime() {		
		long start = System.currentTimeMillis();
		dosomething();
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	public abstract void dosomething();
}
class SubGetTime extends GetTime {
	@Override
	public void dosomething() {
		for (int i=0; i<10000000; i++)
			System.out.print("");;
	}
}