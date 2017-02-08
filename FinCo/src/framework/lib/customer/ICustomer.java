package framework.lib.customer;

import framework.lib.account.IAccount;
import framework.lib.functor.IFunctor;
import framework.lib.predicate.IPredicate;

/**
 * @author Suresh Adhikari
 *
 */
@SuppressWarnings("rawtypes")
public interface ICustomer {

	public void addAccount(IAccount account);

	public void removeAccount(IAccount account);

	public void sendEmail(IFunctor f, IPredicate p, double amount);

	public double getBalance();

	public String getType();

	public IPredicate getDepositPredicate();

	public IPredicate getWithdrawPredicate();

	public String getName();

	public void setName(String name);

}
