package com.asd.group1.framework.app.customer;

import com.asd.group1.framework.lib.account.IAccount;
import com.asd.group1.framework.lib.customer.ACustomer;
import com.asd.group1.framework.lib.customer.ICompany;
import com.asd.group1.framework.lib.functor.IFunctor;
import com.asd.group1.framework.lib.predicate.IPredicate;

/**
 * @author Suresh Adhikari
 *
 */
public class Company extends ACustomer implements ICompany {

	private int noOfEmployee = 0;

	public int getNoOfEmployee() {
		return noOfEmployee;
	}

	public void setNoOfEmployee(int noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}

	@Override
	public void addAccount(IAccount account) {

	}

	@Override
	public void removeAccount(IAccount account) {

	}

	@Override
	public void sendEmail(IAccount account, String msg) {

	}

	@Override
	public void sendEmail(IFunctor f, IPredicate p, double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IPredicate getDepositPredicate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPredicate getWithdrawPredicate() {
		// TODO Auto-generated method stub
		return null;
	}

}
