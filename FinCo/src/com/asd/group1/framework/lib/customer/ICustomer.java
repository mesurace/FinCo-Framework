package com.asd.group1.framework.lib.customer;

import com.asd.group1.framework.lib.functor.IFunctor;
import com.asd.group1.framework.lib.model.IAccount;
import com.asd.group1.framework.lib.predicate.IPredicate;

/**
 * @author Suresh Adhikari
 *
 */
public interface ICustomer {

	public void addAccount(IAccount account);

	public void removeAccount(IAccount account);

	public void sendEmail(IAccount account, String msg);

	public double getBalance();

	public void sendEmail(IFunctor f, IPredicate p, double amount);

	public IPredicate getDepositPredicate();

	public IPredicate getWithdrawPredicate();

}
