package com.asd.group1.framework.lib.customer;

import com.asd.group1.framework.lib.account.IAccount;
import com.asd.group1.framework.lib.functor.IFunctor;
import com.asd.group1.framework.lib.predicate.IPredicate;

/**
 * @author Suresh Adhikari
 *
 */
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
