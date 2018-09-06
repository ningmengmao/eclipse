package mypackage.myGenerics;

class CountedObject {
	private static long counter = 0;
	private final long id = counter++;
	public long id() {
		return id;
	}
	@Override
	public String toString() {
		return "CountedObject " + id;
	}
}
public class BaseGeneratorDemo {

	public static void main(String[] args) {
		Generator<CountedObject> gen = new BaseGenerator<>(CountedObject.class);
//		Generator<CountedObject> gen = BaseGenerator.create(CountedObject.class);
		for (int i=0; i<5; i++) {
			System.out.println(gen.next());
		}
	}

}
