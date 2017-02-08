package framework.lib.account;

import framework.lib.customer.ICustomer;
import framework.lib.transaction.ITransaction;

/**
 *
 * @author Manish Karki
 */
public interface IAccount {
	
	public void addTransaction(ITransaction transaction);

    public double getCurrentBalance();

    public String getType();

    public double getInterestAmount();

    public void updateAmountByTransaction(ITransaction transaction);

    public String getAcctNumber();
    
    public String generateReport();
    
    public double getBalance();
    
    public ICustomer getCustomer();
    
    public void setCustomer(ICustomer customer);

}

