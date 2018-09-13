package mypackage.bank;

import java.util.Iterator;

public class CustomerReport {
	@SuppressWarnings("static-access")
	public void generateReport() {
		Bank bank = Bank.getBank();
		Customer customer;
		// Generate a report
		System.out.println("\t\t\tCUSTOMERS REPORT");
		System.out.println("\t\t\t================");
		Iterator<Customer> iterCustomer = bank.getCustomers();
		while(iterCustomer.hasNext()) {
			customer = iterCustomer.next();
			System.out.println();
			System.out.println("Customer: "
					+ customer.getLastName() + ", "
					+ customer.getFirstName());
			Iterator<Account> iterAccount = customer.getAccounts();
			while(iterAccount.hasNext()) {
				Account account = iterAccount.next();
				String  account_type = "";				
				if(account instanceof SavingAccount)
					account_type += "Savings Account: ";
				else
					account_type += "CheckingAccount: ";
				account_type += "currency balance is $ " + account.getBalance();
				System.out.println(account_type);			
			}
		}
	}
}
