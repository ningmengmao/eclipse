package mypackage.myGenerics;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

class Employee implements Comparable<Employee> {
	private String name;
	private int age;
	private MyDate birthday;

	public Employee() {
		this.name = null;
		this.age = -1;
		this.birthday = null;
	}
	
	public Employee(String name, int age, MyDate birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setBirthday(int m, int d, int y) {
		this.birthday = new MyDate(m, d, y);
	}
	@Override
	public String toString() {
		return "name: " + name + " age: " + age + " birthday: " + birthday; 
	}
	@Override
	public int compareTo(Employee n) {
		return this.name.compareTo(n.name);
	}
}

public class NewTest2 {

	public static void main(String[] args) {
		Set<Employee> s = new TreeSet<>();
		Random r = new Random();
		for (int i=0; i<5; i++) 
			s.add(new Employee(RandomString.getRandomString(3),r.nextInt(40), 
					new MyDate(r.nextInt(12), r.nextInt(30), r.nextInt(2020))));
		Iterator<Employee> iter = s.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
}

class RandomString {
	 public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
}

class MyDate {
	private int month;
	private int year;
	private int day;
	
	public MyDate() {
		this.month = 1;
		this.day = 1;
		this.year = 1970;
	}	
	public MyDate(int month, int day, int year) {
		this.month = month;
		this.year = year;
		this.day = day;
	}
	@Override
	public String toString() {
		return month + "." + day + "." + year;
	}	
}