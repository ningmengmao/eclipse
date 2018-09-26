package mypackage.Enum;

enum Apple1 {
	Jonathan(10), GoldenDel(9), RedDel, Winesap(15), Cortland(8); //在这里调用构造函数 
	private int price;
	Apple1(){
		price = -1;
	}
	Apple1(int p){
		price = p;
	}
	int getPrice() {
		return price;
	}
}
	
public class EnumDemo1 {

	public static void main(String[] args) {
		Apple1 ap; 		// 为每个常量各调用一次构造函数!!!!
		System.out.println("Winesap costs "+ Apple1.Winesap.getPrice());
		System.out.println();
		System.out.println("All apple prices:");
		for(Apple1 a : Apple1.values()) {
			System.out.println(a + " costs "+a.getPrice());
		}
	}

}
