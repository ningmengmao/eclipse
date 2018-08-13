package github_project_1;

public interface IntStack {
	void push(int item);
	int pop();
	default void clear() {
		System.out.println("clear() not implemented.");
	}
}
