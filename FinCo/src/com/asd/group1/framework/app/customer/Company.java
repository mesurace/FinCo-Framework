package com.asd.group1.framework.app.customer;

import java.util.List;

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

	private int noOfEmployee = 1;
	private final String type = "C";
	private List<Person> personList;
	private IFunctor functor;

	public int getNoOfEmployee() {
		return noOfEmployee;
	}

	public void setNoOfEmployee(int noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void addPersonToList(Person person) {
		this.personList.add(person);
	}

	@Override
	public void addAccount(IAccount account) {
		super.addAccount(account);
	}

	@Override
	public void removeAccount(IAccount account) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void sendEmail(IFunctor f, IPredicate p, double amount) {
		if (p != null) {
			if (p.check(amount)) {
				if (f != null) {
					f.compute(this);
				}
			}
		} else {
			f.compute(this);
		}
	}

	@Override
	public String getType() {
		return type;
	}

	public IPredicate getDepositPredicate() {
		return null;
	}

	public IPredicate getWithdrawPredicate() {
		return null;
	}

}
