package mypackage.reflect;

import java.lang.reflect.Field;

public class MyTool {
	/**
	 * 将object中的 propertyName字段设置为value
	 * @param obj
	 * @param propertyName
	 * @param value
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public void setProperty(Object obj, String propertyName, Object value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class c = obj.getClass();
		Field f = c.getDeclaredField(propertyName);
		f.setAccessible(true);
		f.set(obj, value);
		
	}
}
