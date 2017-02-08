
package com.asd.group1.bank.controller;

import java.awt.event.ActionEvent;

import com.asd.group1.bank.dialog.WithdrawDialog;
import com.asd.group1.framework.gui.AccountFrm;
import com.asd.group1.framework.gui.JDialog_Dialogview;
import com.asd.group1.singleton.SingletonProvider;

public class WithdrawController extends com.asd.group1.framework.gui.controller.WithdrawController {

	public WithdrawController() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		AccountFrm accountFrm = SingletonProvider.getInstanceAccountFrm();
		String accnr = accountFrm.getAccountNo();
		JDialog_Dialogview dep = new WithdrawDialog(accountFrm, accnr);
		dep.setBounds(430, 15, 275, 140);
		dep.show();
	}

}
