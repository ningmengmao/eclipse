package github_project_1;

class Stack {
	private int stck[] = new int[10];
	private int tos;
	
	Stack() {
		tos = -1;
	}
	
	void push(int item) {
		if (tos == 9)
			System.out.println("Stack is full.");
		else
			stck[++tos] = item;
	}
	
	int pop() {
		if (tos < 0) {
			System.out.println("Stack underflow.");
			return 0;
		}
		else {
			return stck[tos--];
		}
	}
}

public class TestStack {

	public static void main(String[] args) {
		Stack mystack1 = new Stack();
		Stack mystack2 = new Stack();
		
		for(int i=0; i<10; i++)
			mystack1.push(i);
		for(int i=10; i<20; i++)
			mystack2.push(i);
		System.out.println("in mystack1:");
		for(int i=0; i<10; i++)
			System.out.print(mystack1.pop()+" ");
		System.out.println("\n"+"in mystack2:");
		for(int i=0; i<10; i++)
			System.out.print(mystack2.pop()+" ");
	}

}
