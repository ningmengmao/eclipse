package mypackage.reflect;

import java.lang.reflect.Constructor;

public class Test4 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> c = Class.forName("mypackage.reflect.Person");
		Constructor<?>[] constructor = c.getConstructors();
		for(Constructor<?> con : constructor) {
			Class<?>[] clas = con.getParameterTypes();
			for(Class<?> clz : clas) {
				System.out.print(clz.getName() + " ");
			}
			System.out.println();
		}
	}

}
