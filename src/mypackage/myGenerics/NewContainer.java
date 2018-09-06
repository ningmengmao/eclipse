package mypackage.myGenerics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NewContainer {
	/**
	 * 根据类型参数推断,返回HashMap
	 * @return new HashMap<K,V>()
	 */
	public static <K,V> Map<K,V> map(){
		return new HashMap<K,V>();
	}
	public static <T> List<T> list(){
		return new ArrayList<T>();
	}
	public static <T> LinkedList<T> lList(){
		return new LinkedList<T>();
	}
	public static <T> Set<T> set() {
		return new HashSet<T>();
	}
	public static <T> Queue<T> queue() {
		return new LinkedList<T>();
	}
	
	public static void main(String... args) {
		Map<String, List<String>> m = NewContainer.map();
		m.put("first", new ArrayList<String>(Arrays.asList("This is first".split(" "))));
		System.out.println(m.keySet().iterator().next().getClass().getName());
		System.out.println(m.get("first").getClass().getName());
		
	}

}
