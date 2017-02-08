package framework.lib.transaction;

import framework.lib.account.AccountManager;
import framework.lib.account.IAccount;
import framework.lib.customer.ICustomer;
import framework.lib.functor.IFunctor;

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
