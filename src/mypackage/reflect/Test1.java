package mypackage.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {

	@SuppressWarnings({ "rawtypes", "unchecked"})
	public static void main(String[] args) throws Exception {
		Class ps = Class.forName("mypackage.reflect.Person");
		Person p = (Person) ps.newInstance();    // 无参构造方法
		Constructor pc = ps.getConstructor(String.class, int.class);
		Person p1 = (Person) pc.newInstance("张三", 20);  
		Method m = ps.getMethod("eat", String.class);
		m.invoke(p1, "菩提");
		Field fn = ps.getField("name");
		Field fa = ps.getDeclaredField("age");
		fa.setAccessible(true);
		fa.set(p, 21);
		fn.set(p, "李四");
		System.out.println(p + "\n" + p1);
	}

}
