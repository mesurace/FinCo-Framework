package com.asd.group1.framework.app.customer;

import java.util.Date;

import com.asd.group1.framework.lib.customer.ACustomer;
import com.asd.group1.framework.lib.customer.IPerson;
import com.asd.group1.framework.lib.functor.IFunctor;
import com.asd.group1.framework.lib.model.IAccount;
import com.asd.group1.framework.lib.predicate.IPredicate;

/**
 * @author Suresh Adhikari
 *
 */
public class Person extends ACustomer implements IPerson {

	private Date birthDate;

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public void addAccount(IAccount account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAccount(IAccount account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendEmail(IAccount account, String msg) {
		// TODO Auto-generated method stub

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
