package mypackage.bank;

import java.util.Iterator;

public abstract class Account {
	protected double balance; //当前余额
	
	public Account(double balance) {
		this.balance = balance;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amt ) {
		balance += amt;
	}
	public void withdraw(double amt) throws OverdraftException {
		if(balance >= amt)
			balance -= amt;
		else
			throw new OverdraftException("资金不足", amt-balance);
	}	
}
