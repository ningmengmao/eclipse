package mypackage.CodeJava;
import java.util.*;
import java.lang.reflect.*;

public class CopyOfTest {
	/**
	 * This method grows an array by allocating a new array of 
	 * the same copying all elements .
	 * @param obj can be an object array or primitive type array
	 * @param newLength
	 * @return newArray
	 */
	public static Object copyOf(Object obj, int newLength) {
		Class cl = obj.getClass();
		if(!cl.isArray())
			return null;
		Class componentType = cl.getComponentType();
		int length = Array.getLength(obj);
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(obj, 0, newArray, 0, Math.min(length, newLength));
		return newArray;
	}
	
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		a = (int[]) copyOf(a,10);
		System.out.println(Arrays.toString(a));
		
		String[] b = {"Tom", "Bob", "Harry"};
		b = (String[]) copyOf(b, 10);
		System.out.println(Arrays.toString(b));
	}

}
