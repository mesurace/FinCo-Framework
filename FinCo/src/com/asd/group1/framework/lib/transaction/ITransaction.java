package com.asd.group1.framework.lib.transaction;

import com.asd.group1.framework.lib.account.AccountManager;
import com.asd.group1.framework.lib.account.IAccount;
import com.asd.group1.framework.lib.customer.ICustomer;
import com.asd.group1.framework.lib.functor.IFunctor;

/**
 *
 * @author Manish Karki
 */
public interface ITransaction {
	public double getSignedAmount();
	public void compute();
	public IFunctor<ICustomer> getFunctor();
	public void setupTransaction(AccountManager accountManager, IAccount account);
}

