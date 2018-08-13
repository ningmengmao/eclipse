/*
 * 注解
 */
package mypackage.Enum;
import java.lang.annotation.*;
import java.lang.reflect.*;

// 自定义注解,保留在JVM运行中
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	String str();
	int val();
}

public class Meta {
	@MyAnno(str = "Annotation Example", val = 100)
	public static void myMeth(String str, int i) {
		Meta ob = new Meta();
		
		try {
			// 获得Class对象
			Class<?> c = ob.getClass();    // 或 Class<?> c = Meta.class;
			
			// 获得Method对象 String.class, int.class是参数的Class对象
			Method m = c.getMethod("myMeth", String.class, int.class);
			
			// 获得method的注解
			// MyAnno.class返回MyAnno的Class对象
			MyAnno anno = m.getAnnotation(MyAnno.class);
			System.out.println(anno.str()+" "+anno.val());
		} catch(NoSuchMethodException e) {
			System.out.println("Method Not Found.");
		}
	}
	public static void main(String[] args) {
		myMeth("test", 10);
	}

}
