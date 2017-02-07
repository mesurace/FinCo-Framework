package com.asd.group1.framework.lib.transaction;

import com.asd.group1.framework.lib.customer.ICustomer;
import com.asd.group1.framework.lib.functor.IFunctor;
import com.asd.group1.framework.lib.model.AccountManager;
import com.asd.group1.framework.lib.model.IAccount;

/**
 *
 * @author Manish Karki
 */
public interface ITransaction {
	public double getSignedAmount();

	public void compute();

	public void setAccount(IAccount account);

	public IAccount getAccount();

	public IFunctor<ICustomer> getFunctor();

	public void setupTransaction(AccountManager accountManager, IAccount account);

	public double getAmount();
	
	public void setAmount(double amount);

	public void setName(String name);
}
