package com.asd.group1.framework.lib.transaction;

import java.util.List;

/**
 *
 * @author Manish Karki
 */
public class TransactionManager {
	private List<ITransaction> transactions;

	public void invoke(ITransaction transaction) {
		transaction.compute();
		transactions.add(transaction);
	}
	
	public List<ITransaction> getTransactions() {
		return transactions;
	}

}
