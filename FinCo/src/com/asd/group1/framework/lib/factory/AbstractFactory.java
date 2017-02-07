package com.asd.group1.framework.lib.factory;

import com.asd.group1.framework.lib.account.IAccount;
import com.asd.group1.framework.lib.customer.ICustomer;
import com.asd.group1.framework.lib.transaction.ITransaction;

/**
 *
 * @author Manish Karki
 */
@SuppressWarnings("rawtypes")
public class AbstractFactory {

	public ICustomer getCustomer(Enum type);

    public IAccount getAccount(Enum type);

    public ITransaction getTransaction(Enum type);
}

