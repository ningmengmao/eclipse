package mypackage;

public interface MyIF {
	// 标准的接口方法
	int getNumber();
	
	// 带默认方法的
	default String getString() {
		return "Default String.";
	}
	
	// 静态接口方法 MyIF.getDefaultNumber 调用
	static int getDefaultNumber() {
		return 0;
	}
}