/*
 * 装箱 拆箱
 * 自动装箱 自动拆箱
 */
package github_project_1.Enum;

public class Wrap {

	public static void main(String[] args) {
		Integer iOb = new Integer(100);		//	装箱
		int i = iOb.intValue();				//	拆箱
		Integer iOb2 = 100;					//  自动装箱
		int i2 = iOb2;						//  自动拆箱
		System.out.println(i+" "+iOb);
		System.out.println(i2+" "+iOb2);

	}

}
