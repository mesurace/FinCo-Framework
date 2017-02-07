package com.asd.group1.singleton;

import com.asd.group1.framework.gui.AccountFrm;
import com.asd.group1.framework.lib.account.AccountManager;
import com.asd.group1.framework.lib.mediator.Mediator;

public class SingletonProvider {
	private static AccountManager accountManager = null;
	 private static AccountFrm instance = null;
	private static Mediator mediator = null;

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
}
