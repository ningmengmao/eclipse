package mypackage.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyUsersProxy implements InvocationHandler {
	private Object obj;
	
	 public MyUsersProxy(Object obj) {
		 this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理");
		method.invoke(obj, args);				
		System.out.println("代理");
		return null;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) throws Throwable {
		Class c = Class.forName("mypackage.reflect.proxy.Users");
		Users users = (Users) c.newInstance();
		User u = (User) Proxy.newProxyInstance(c.getClassLoader(), 
				c.getInterfaces(), new MyUsersProxy(users));
		u.add();
		u.delete();
	}

}
