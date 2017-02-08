
package framework.gui.controller;

import java.awt.event.ActionEvent;

import framework.gui.AccountFrm;
import framework.gui.JDialog_AddAccount;
import framework.lib.account.AccountManager;
import singleton.SingletonProvider;

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
