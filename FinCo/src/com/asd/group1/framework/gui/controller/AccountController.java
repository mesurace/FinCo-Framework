
package com.asd.group1.framework.gui.controller;

import java.awt.event.ActionEvent;

import com.asd.group1.framework.gui.AccountFrm;
import com.asd.group1.framework.gui.JDialog_AddAccount;
import com.asd.group1.framework.lib.model.AccountManager;
import com.asd.group1.singleton.SingletonProvider;

/**
 *
 * @author Manish Karki
 */
public class AccountController implements Controller {

    private AccountManager accountManager = null;

    public AccountController() {
        accountManager = SingletonProvider.getInstanceAccountManager();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm = SingletonProvider.getInstanceAccountFrm();
        JDialog_AddAccount pac = new JDialog_AddAccount(accountFrm);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

    }

}
