package mypackage.bank;

import java.util.ArrayList;
import java.util.Iterator;

public class Bank {
	private static ArrayList<Customer> customers ;
	private static Bank bank = new Bank();

	private Bank() {
		customers = new ArrayList<>();
	}
	public static Bank getBank() {
		return bank;
	}
	public static void addCustomer(String f, String l) {
		customers.add(new Customer(f, l));
	}
	public static int getNumOfCustomer() {
		return customers.size();
	}
	public static Customer getCustomer(int index) {
		return customers.get(index);
	}
	public static Iterator<Customer> getCustomers() {
		return customers.iterator();
	}
}
