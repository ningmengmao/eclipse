package mypackage.bank;

public class CheckingAccount extends Account {
	private double overdraftProtection;
	
	public CheckingAccount(double balance) {
		super(balance);
	}
	public CheckingAccount(double balance, double overdraftProtection) {
		super(balance);
		this.overdraftProtection = overdraftProtection;
	}
	@Override 
	public  void withdraw(double amt) throws OverdraftException{
		if ( balance >= amt) {
			balance -= amt;
		}
		else if (overdraftProtection == 0)
			throw new OverdraftException("no overdraft protection", amt);
		else if (balance + overdraftProtection >= amt) {
			balance = 0;
			overdraftProtection += balance - amt;
		}
		else 
			throw new OverdraftException("Insufficient funds for overdraft protection",
					amt);
	}
}
