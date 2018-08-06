/*
 *  实现接口
 *  调用接口
 */
package github_project_1;

class FixedStack implements IntStack {
	private int stck[];
	private int tos ;
	
	FixedStack(int size) {
		stck = new int[size];
		tos = -1;
	}
	public void push(int item) {
		if (tos == stck.length - 1)
			System.out.println("Stack is full.");
		else 
			stck[++tos] = item;
	}
	public int pop() {
		if (tos == -1) {
			System.out.println("Stack underflow.");
			return 0;
		}
		else 
			return stck[tos--];
	}
}

class DynStack implements IntStack {
	private int stck[];
	private int tos;
	
	DynStack(int size) {
		stck = new int[size];
		tos = -1;
	}
	public void push(int item) {
		if (tos == stck.length - 1) {
			int temp[] = new int[stck.length * 2];
			for(int i=0; i<stck.length; i++)
				temp[i] = stck[i];
			stck = temp;
			stck[++tos] = item;
		}
		else 
			stck[++tos] = item;
	}
	public int pop() {
		if (tos == -1) {
			System.out.println("Stack underflow.");
			return 0;
		}
		else 
			return stck[tos--];	
	}
}

public class IFTest {

	public static void main(String[] args) {
		IntStack mystack;
		
		mystack = new FixedStack(5);
		for(int i=0; i<5; i++)
			mystack.push(i);
		System.out.println("Stack in FixedStack");
		for(int i=0; i<5; i++)
			System.out.println(mystack.pop());
		
		mystack = new DynStack(8);
		for(int i=0; i<15; i++)
			mystack.push(i);
		System.out.println("Stack in DynStack");
		for(int i=0; i<15; i++)
			System.out.println(mystack.pop());
		
	}

}
