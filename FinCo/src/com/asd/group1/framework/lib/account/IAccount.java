package com.asd.group1.framework.lib.account;

import com.asd.group1.framework.lib.transaction.ITransaction;

/**
 *
 * @author Manish Karki
 */
public interface IAccount {
	
	public void addEntry(ITransaction transaction);

    public double getCurrentBalance();

    public String getType();

    public double getInterestAmount();

    public void updateAmountByTransaction(ITransaction transaction);

    public String getAcctNumber();

    public String generateReport();
    
    public double getBalance();

}

