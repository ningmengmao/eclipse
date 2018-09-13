package mypackage.bank;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
	private String firstName;
	private String lastName;
	private ArrayList<Account> accounts;
 	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		accounts = new ArrayList<>();
	}
	public void addAccount(Account acct) {
		accounts.add(acct);
	}
	public Account getAccount(int index) {
		return accounts.get(index);
	}
	public int getNumOfAccount() {
		return accounts.size();
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Iterator<Account> getAccounts(){
		return accounts.iterator();
	}


}
