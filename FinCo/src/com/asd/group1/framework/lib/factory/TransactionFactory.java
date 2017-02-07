package com.asd.group1.framework.lib.factory;

import com.asd.group1.framework.app.type.TransactionType;
import com.asd.group1.framework.lib.transaction.Deposit;
import com.asd.group1.framework.lib.transaction.ITransaction;
import com.asd.group1.framework.lib.transaction.Withdraw;

/**
 *
 * @author Manish Karki
 */
public class TransactionFactory extends AbstractFactory{

	@SuppressWarnings("rawtypes")
	public ITransaction getTransaction(Enum type){
		if (type == TransactionType.DEPOSIT) {
            return new Deposit();
        } else if (type == TransactionType.WITHDRAW) {
            return new Withdraw();
        }
        return null;
	}
}

