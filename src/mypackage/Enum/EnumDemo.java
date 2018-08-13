/*
 * 枚举
 */
package mypackage.Enum;

enum Apple {
	Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

public class EnumDemo {

	public static void main(String[] args) {
		Apple ap;
		System.out.println("Here are all Apple constants:");
		Apple allapples[] = Apple.values();
		for(Apple a : allapples) {
		// for(Apple a : Apple.valuse()) {   相同
			System.out.println(a);
		}
		System.out.println();
		ap = Apple.valueOf("Winesap");
		System.out.println("ap contains: "+ap);
	}

}
