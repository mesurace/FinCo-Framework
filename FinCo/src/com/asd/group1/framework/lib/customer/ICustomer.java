package com.asd.group1.framework.lib.customer;

import com.asd.group1.framework.lib.account.IAccount;

/**
 * @author Suresh Adhikari
 *
 */
public interface ICustomer {
	
	public void addAccount(IAccount account);
	public void removeAccount(IAccount account);
	public void sendEmail(IAccount account,String msg);

}
