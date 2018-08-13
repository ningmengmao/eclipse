package github_project_1.CodeJava;
import java.lang.reflect.*;
import java.util.Scanner;
/**
 * use reflection to print all features of class.
 * @author ningmengmao
 */
public class ReflectionTest {
	/**
	 * Prints all constructors(构造函数) of a class
	 * 打印一个类的所有构造函数
	 * @param cl
	 */
	public static void printConstructors(Class cl) {
		Constructor[] constructors = cl.getDeclaredConstructors();
		for(Constructor c : constructors) {
			String name = c.getName();
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.print(name + "(");
			Class[] paramTypes = c.getParameterTypes();
			for(int i=0; i<paramTypes.length; i++) {
				if(i > 0)
					System.out.print(", ");
				System.out.print(paramTypes[i].getName());
			}
			System.out.println(");");
		}
	}
	/**
	 * prints all methods of a class
	 * 打印一个类的所有方法
	 * @param cl
	 */
	public static void printMethods(Class cl) {
		Method[] methods = cl.getDeclaredMethods();
		for(Method m : methods) {
			Class retType = m.getReturnType();
			String name = m.getName();
			System.out.print("  ");
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.print(retType.getName() + " " + name + "(");
			Class[] paramTypes = m.getParameterTypes();
			for(int i=0; i<paramTypes.length; i++) {
				if(i > 0)
					System.out.print(",");
				System.out.print(paramTypes[i].getName());
			}
			System.out.println(")");
		}
	}
	/**
	 * print all fields of a class
	 * 打印一个类的所有域
	 * @param cl
	 */
	public static void printFields(Class cl) {
		Field[] fields = cl.getDeclaredFields();
		for(Field f : fields) {
			Class type = f.getType();
			String name = f.getName();
			System.out.print("  ");
			String modifiers = Modifier.toString(f.getModifiers());
			if(modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}
	}
	
	public static void main(String[] args) {
		String name;
		if(args.length > 0)
			name = args[0];
		else
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name (e.g. java.util.Data)");
			name = in.next();
		}
		try {
			Class cl = Class.forName(name);
			Class supercl = cl.getSuperclass();
			// 获取修饰符
			String modifiers = Modifier.toString(cl.getModifiers());
			if(modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.print("class " + name);
			if(supercl != null && supercl != Object.class)
				System.out.print(" extends " + supercl.getName());
			System.out.print("\n{\n");
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFields(cl);
			System.out.println("}");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

}
