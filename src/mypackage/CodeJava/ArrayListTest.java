package mypackage.CodeJava;
import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Employee> staff = new ArrayList<>();
		staff.add(new Employee("Carl Cracker", 75000));
		staff.add(new Employee("Harry Hacker", 50000));
		staff.add(new Employee("Tony Tester", 40000));
		for(Employee e : staff) {
			e.raiseSalary(5);
			System.out.println(e);
		}
	}
}
