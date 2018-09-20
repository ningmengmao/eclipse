package mypackage.reflect.proxy;

public class Users implements User {
	@Override
	public void add() {
		System.out.println("add something");	
	}
	@Override
	public void delete() {
		System.out.println("delete something");
	}
}
