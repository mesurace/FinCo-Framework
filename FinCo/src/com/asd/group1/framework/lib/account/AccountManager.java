package com.asd.group1.framework.lib.account;

import com.asd.group1.framework.lib.customer.ICustomer;
import com.asd.group1.framework.lib.functor.IFunctor;
import com.asd.group1.framework.lib.mediator.Mediator;
import com.asd.group1.framework.lib.mediator.Message;
import com.asd.group1.framework.lib.predicate.IPredicate;
import com.asd.group1.framework.lib.transaction.Deposit;
import com.asd.group1.framework.lib.transaction.ITransaction;
import com.asd.group1.framework.lib.transaction.TransactionManager;
import com.asd.group1.singleton.SingletonProvider;

/**
 *
 * @author Manish Karki
 */
public class AccountManager {

	private static final String UPDATE_ACCOUNT_TABLE = "UPDATE_ACCOUNT_TABLE";
	public static final String ACCOUNT_SELECTED = "ACCOUNT_SELECTED";
    public static final String ACCOUNT_LIST_NOT_EMPTY = "ACCOUNT_LIST_NOT_EMPTY";

	private TransactionManager transactionManager = null;
	private Mediator mediator;

	public AccountManager(Mediator mediator) {
		transactionManager = SingletonProvider.getInstanceTransactionManager();
		this.mediator = mediator;
		this.send(new Message(ACCOUNT_LIST_NOT_EMPTY, false));
		this.send(new Message(ACCOUNT_SELECTED, false));
	}

	public void removeAccount(IAccount account) {

	}

	public void addAccountTransaction(IAccount account, ITransaction transaction) {
		account.addTransaction(transaction);
		account.updateAmountByTransaction(transaction);

		IPredicate<Double> p;
		IFunctor<ICustomer> f;

		if (transaction instanceof Deposit) {
			p = account.getCustomer().getDepositPredicate();
			f = transaction.getFunctor();
		} else {
			p = account.getCustomer().getWithdrawPredicate();
			f = transaction.getFunctor();
		}

		account.getCustomer().sendEmail(f, p, account.getCurrentBalance());
		this.updateAccountTable();

	}

	public void updateAccountTable() {
		this.send(new Message(UPDATE_ACCOUNT_TABLE, true));
	}

	private void send(Message message) {
		mediator.send(this, new Message(message.getsub(), message.isStatus()));

	}

	public IAccount getAccountById(String accrno) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deposit(IAccount account, ITransaction iTransaction) {
		performTransaction(account, iTransaction);
	}

	public void Withdraw(IAccount account, ITransaction transaction) {
		performTransaction(account, transaction);
	}

	/*
	 * Pass transaction to command to execute. This will perform transaction by
	 * command pattern
	 */
	public void performTransaction(IAccount account, ITransaction transaction) {
		transaction.setupTransaction(this, account);
		transactionManager.invoke(transaction);
	}

	public void addInterest() {
		// TODO Auto-generated method stub
		
	}
}
