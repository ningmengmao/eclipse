package mypackage.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test1 {

	public static void main(String[] args) throws Exception {
//		t();
		t1();
	}
	public static void t1() {
		Person p = new Person("张三", 20);
		MyTool mytool = new MyTool();
		System.out.println(p);
		try {
			mytool.setProperty(p, "name", "李四");
			mytool.setProperty(p, "age", 21);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println(p);
//		try {
//			mytool.setProperty(p, "name", 10);	//非法赋值
//		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(p);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked"})
	public static void t() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
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
