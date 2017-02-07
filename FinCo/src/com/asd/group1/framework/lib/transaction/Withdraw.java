package com.asd.group1.framework.lib.transaction;

import com.asd.group1.framework.app.functor.NegativeBalanceFunctor;
import com.asd.group1.framework.lib.account.AccountManager;
import com.asd.group1.framework.lib.account.IAccount;
import com.asd.group1.framework.lib.customer.ICustomer;
import com.asd.group1.framework.lib.functor.IFunctor;

/**
 *
 * @author Manish Karki
 */
public class Withdraw extends ATransaction{

	private AccountManager accountManager;
    private IAccount account;

	@Override
	public double getSignedAmount() {
		return -1 * this.getAmount();
	}

	@Override
	public void compute() {
		accountManager.addAccountTransaction(account, this);
		
	}

	@Override
	public IFunctor<ICustomer> getFunctor() {
		return new NegativeBalanceFunctor();
	}

	@Override
	public void setupTransaction(AccountManager accountManager, IAccount account) {

		this.account = account;
		this.accountManager = accountManager;
	}

}

