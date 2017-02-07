package com.asd.group1.framework.lib.factory;

import com.asd.group1.framework.app.account.FincoAccount;
import com.asd.group1.framework.app.type.AccountType;
import com.asd.group1.framework.lib.account.IAccount;

/**
 *
 * @author Manish Karki
 */
@SuppressWarnings({ "rawtypes"})
public class AccountFactory extends AbstractFactory{

	public IAccount getAccount(Enum type){
		if (type == AccountType.DEFAULT_ACCOUNT) {
            return new FincoAccount();
        }
        return null;
	}
}

