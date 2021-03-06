package framework.lib.transaction;

import framework.app.functor.NewBalanceFunctor;
import framework.lib.account.AccountManager;
import framework.lib.account.IAccount;
import framework.lib.customer.ICustomer;
import framework.lib.functor.IFunctor;

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
		return 1 * this.getAmount();
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

