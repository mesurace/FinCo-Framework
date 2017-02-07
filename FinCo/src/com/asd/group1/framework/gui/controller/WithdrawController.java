package com.asd.group1.framework.gui.controller;


import java.awt.event.ActionEvent;

import com.asd.group1.framework.app.type.TransactionType;
import com.asd.group1.framework.app.type.Types;
import com.asd.group1.framework.lib.account.AccountManager;
import com.asd.group1.framework.lib.account.IAccount;
import com.asd.group1.framework.lib.factory.FincoFactory;
import com.asd.group1.framework.lib.transaction.ITransaction;

/**
 *
 * @author Manish Karki
 */
public class WithdrawController implements Controller {

    private AccountManager accountManager = null;

    public WithdrawController() {
        accountManager = SingletonProvider.getInstanceAccountManager();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm = SingletonProvider.getInstanceAccountFrm();
        String accnr = accountFrm.getAccountNo();
        JDialog_Dialogview dep = new JDialog_Dialogview(accountFrm, accnr);
        dep.setBounds(430, 15, 275, 140);
        dep.show();
    }

    public WithdrawController(String accrno, String amount) {
        this();
    }

    public void withdraw(String accrno, String amount, String name) {
        try {
            IAccount account = accountManager.getAccountById(accrno);
            ITransaction iTransaction = FincoFactory.getFactory(Types.TRANSACTION).getTransaction(TransactionType.WITHDRAW);
            iTransaction.setAmount(Double.parseDouble(amount));
            iTransaction.setName(name);
            accountManager.Withdraw(account, iTransaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
