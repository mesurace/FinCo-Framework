
package com.asd.group1.framework.gui.controller;

import java.awt.event.ActionEvent;

import com.asd.group1.framework.gui.AccountFrm;
import com.asd.group1.framework.lib.account.AccountManager;

/**
 *
 * @author Manish Karki
 */
public class AccountController implements Controller {

    private AccountManager accountManager = null;

    public AccountController() {
        accountManager = ClassicSingleton.getInstanceAccountManager();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm = ClassicSingleton.getInstanceAccountFrm();
        JDialog_AddAccount pac = new JDialog_AddAccount(accountFrm);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

    }

}
