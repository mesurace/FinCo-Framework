package com.asd.group1.framework.app.customer;

import java.util.Date;

import com.asd.group1.framework.lib.account.IAccount;
import com.asd.group1.framework.lib.customer.IPerson;

/**
 * @author Suresh Adhikari
 *
 */
public class Person implements IPerson {

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

}
