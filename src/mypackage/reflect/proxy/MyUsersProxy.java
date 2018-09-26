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
		/*
		 * proxy 为被代理类,其他jdk自动填充(假如使用user.add() 则method->add, args->null)
		 */
		System.out.println("代理");
		method.invoke(obj, args);				
		System.out.println("代理");
		return null;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) throws Throwable {
		Class c = Class.forName("mypackage.reflect.proxy.Users");
		Users users = (Users) c.newInstance();
		
		/*
		 * 新建代理实例(jdk的proxy只能代理接口)
		 * c.getClassLoader(), c.getInterfaces()默认都是这两个
		 * MyUsersProxy为自定义代理类要实现InvocationHandler, 重写invoke实现代理功能
		 */
		User u = (User) Proxy.newProxyInstance(c.getClassLoader(), 
				c.getInterfaces(), new MyUsersProxy(users));
		u.add();
		u.delete();
	}

}
