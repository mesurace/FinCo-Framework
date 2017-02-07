package com.asd.group1.framework.lib.transaction;

import com.asd.group1.framework.app.functor.NewBalanceFunctor;
import com.asd.group1.framework.lib.account.AccountManager;
import com.asd.group1.framework.lib.account.IAccount;
import com.asd.group1.framework.lib.customer.ICustomer;
import com.asd.group1.framework.lib.functor.IFunctor;

/**
 *
 * @author Manish Karki
 */
public class Deposit extends ATransaction{
	
	public static final String DEPOSIT = "DEPOSIT";
    public static final String DEPOSIT_INTEREST = "INTEREST";

    private AccountManager accountManager;
    private IAccount account;

    @Override
    public void compute() {
        accountManager.addAccountTransaction(account, this);
    }

	@Override
	public double getSignedAmount() {
		return 0;
	}

	@Override
	public IFunctor<ICustomer> getFunctor() {
		return new NewBalanceFunctor();
	}

	@Override
	public void setupTransaction(AccountManager accountManager, IAccount account) {
		this.accountManager = accountManager;
		this.account = account;
	}

}

