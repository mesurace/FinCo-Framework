package com.asd.group1.framework.gui.controller;

import java.awt.event.ActionEvent;

import com.asd.group1.framework.app.type.TransactionType;
import com.asd.group1.framework.app.type.Types;
import com.asd.group1.framework.gui.AccountFrm;
import com.asd.group1.framework.gui.JDialog_Dialogview;
import com.asd.group1.framework.lib.account.AccountManager;
import com.asd.group1.framework.lib.account.IAccount;
import com.asd.group1.framework.lib.factory.FincoFactory;
import com.asd.group1.framework.lib.factory.TransactionFactory;
import com.asd.group1.framework.lib.transaction.ITransaction;
import com.asd.group1.singleton.SingletonProvider;

/**
 *
 * @author Manish Karki
 */
public class DepositController implements Controller {

    private AccountManager accountManager = null;

    public DepositController() {
        accountManager = SingletonProvider.getInstanceAccountManager();
    }

    @SuppressWarnings("deprecation")
	@Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm = SingletonProvider.getInstanceAccountFrm();
        String accnr = accountFrm.getAccountNo();
        JDialog_Dialogview dep = new JDialog_Dialogview(accountFrm, accnr);
        dep.setBounds(430, 15, 275, 140);
        dep.show();
    }

    public DepositController(String accountNumber, String amount) {
        this();
    }

    public void deposit(String accountNumber, String amount, String name) {
        try {
            IAccount account = accountManager.getAccountById(accountNumber);
            ITransaction iTransaction = ((TransactionFactory)FincoFactory.getFactory(Types.TRANSACTION)).getTransaction(TransactionType.DEPOSIT);
            iTransaction.setAmount(Double.parseDouble(amount));
            iTransaction.setName(name);
            accountManager.deposit(account, iTransaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
