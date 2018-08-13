package mypackage.CodeJava;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Comparable<Employee> ,Cloneable  {
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(String aName, double aSalary) {
		name = aName;
		salary = aSalary;
		hireDay = new Date();
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public void setHireDay(int year, int month, int day) {
		Date newHireDay = new GregorianCalendar(year, month-1, day).getTime();
		hireDay.setTime(newHireDay.getTime());
	}
	public Date getHireDay() {
		return hireDay;
	}
	
	public void raiseSalary(double byPercent) {
		this.salary += this.salary * byPercent / 100;
	}
	@Override
	public String toString() {
		return getClass().getName()+" [name="+ name
				+ " nsalary=" + salary + " hireDay=" + hireDay + "]";
	}
	/**
	 * Compares employee by salary
	 * @param other another Employee object
	 */
	@Override
	public int compareTo(Employee other) {
		return Double.compare(this.salary, other.salary);
	}
//  浅拷贝	
//	@Override
//	public Employee clone() throws CloneNotSupportedException {
//		return (Employee) super.clone();
//	}
	@Override
	public Employee clone() throws CloneNotSupportedException {
		Employee cloned = (Employee) super.clone();
		cloned.hireDay = (Date) hireDay.clone();
		return cloned;
	}
	
}
