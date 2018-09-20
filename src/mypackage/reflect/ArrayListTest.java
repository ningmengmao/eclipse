package mypackage.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ArrayListTest {

	/**
	 * 在ArrayList<Integer> 内添加字符串
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
//		list.add("abc");	编译错误 
//      泛型在.class内被擦除为Object类
		Class c = Class.forName("java.util.ArrayList");
		Method m = c.getMethod("add", Object.class);  // add(E e);
		m.invoke(list, "abc");
		System.out.println(list);		
	}

}
