package mypackage.myGenerics;

class TwoTuple<A,B> {
	private final A a;
	private final B b;
	public TwoTuple(A a, B b) {
		this.a = a;
		this.b = b;
	}	
}
class ThreeTuple<A,B,C> extends TwoTuple<A,B> {
	private final C c;
	public ThreeTuple(A a, B b, C c) {
		super(a, b);
		this.c = c;
	}
}
class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C> {
	private final D d;
	public FourTuple(A a, B b, C c, D d) {
		super(a, b, c);
		this.d = d;
	}
}
class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D> {
	private final E e;
	public FiveTuple(A a, B b, C c, D d, E e) {
		super(a, b, c, d);
		this.e = e;
	}
}

public class Tuple {
	public static <A,B> TwoTuple<A,B> tuple(A a, B b) {
		return new TwoTuple<A, B>(a, b);
	}
	public static <A,B,C> ThreeTuple<A,B,C> tuple(A a, B b, C c){
		return new ThreeTuple<A, B, C>(a, b, c);
	}
	public static <A,B,C,D> FourTuple<A,B,C,D> tuple(A a, B b, C c, D d){
		return new FourTuple<A, B, C, D>(a, b, c, d);
	}
	public static <A,B,C,D,E> FiveTuple<A,B,C,D,E> tuple(A a, B b, C c, D d, E e){
		return new FiveTuple<A, B, C, D, E>(a, b, c, d, e);
	}
	
}
