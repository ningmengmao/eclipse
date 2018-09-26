package mypackage.reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws ClassNotFoundException, IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//通过config设置要操作的类
		BufferedReader br = new BufferedReader(new FileReader("src/mypackage/reflect/config"));
		Class c = Class.forName(br.readLine());
		br.close();
		Constructor con = c.getConstructor(String.class, int.class);
		Person p = (Person) con.newInstance("张三", 23);
		Method m = c.getDeclaredMethod("run");
		m.setAccessible(true);
		m.invoke(p);
	}

}
