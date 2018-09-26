package mypackage.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0 {
 
	public static void main(String[] args) throws Exception {
//		List<String> list = new ArrayList<>();
//		list.add("aaa");
//		list.add("bbb");
//		list.add("ccc");
//		list.add("ddd");
//		list.add("fff");
//		swapListElement(list, 2, 1);
//		System.out.println(list);
		Integer[] arr = {1,2,3,4,5,6,7};
		reverses(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static <T> void swapListElement(List<T> list, int index1, int index2) throws Exception {
		if(index1 == index2)
			throw new Exception("不能输入两个相同的位置");
		T t1 = list.get(index1);
		T t2 = list.get(index2);
		list.set(index1, t2);
		list.set(index2, t1);
	}
	//数组不能自动装箱拆箱
	public static <T> void reverses(T[] arr) {
		T temp;
		for (int i=0; i<(arr.length / 2); i++) {
			temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}
}
