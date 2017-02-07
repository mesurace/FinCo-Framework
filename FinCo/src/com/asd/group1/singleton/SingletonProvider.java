package com.asd.group1.singleton;

import com.asd.group1.framework.gui.AccountFrm;
import com.asd.group1.framework.lib.account.AccountManager;
import com.asd.group1.framework.lib.mediator.Mediator;
import com.asd.group1.framework.lib.transaction.TransactionManager;

public class SingletonProvider {
	private static AccountManager accountManager = null;
	private static AccountFrm instance = null;
	private static Mediator mediator = null;
	private static TransactionManager transactionManager = null;

	protected SingletonProvider() {
	}

	public static AccountManager getInstanceAccountManager() {
		if (accountManager == null) {
			accountManager = new AccountManager(getMediator());
		}
		return accountManager;
	}

	public static AccountFrm getInstanceAccountFrm() {
		if (instance == null) {
			instance = new AccountFrm();
		}
		return instance;
	}

	public static Mediator getMediator() {
		if (mediator == null) {
			mediator = new Mediator();
		}
		return mediator;
	}

	public static TransactionManager getInstanceTransactionManager() {
		if (transactionManager == null) {
			transactionManager = new TransactionManager(getMediator());
		}
		return transactionManager;
	}
}
