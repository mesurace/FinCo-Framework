package com.asd.group1.framework.app.customer;

import com.asd.group1.framework.lib.account.IAccount;
import com.asd.group1.framework.lib.customer.ICompany;

/**
 * @author Suresh Adhikari
 *
 */
public class Company implements ICompany {

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

}
