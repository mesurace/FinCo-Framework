package com.asd.group1.creditcard.controller;

import java.awt.event.ActionEvent;

import com.asd.group1.creditcard.dialog.JDialogGenBill;
import com.asd.group1.framework.gui.AccountFrm;
import com.asd.group1.framework.gui.controller.Controller;
import com.asd.group1.singleton.SingletonProvider;

/**
 *
 * @author Manish Karki
 */
public class BillController implements Controller{

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent ae) {
		AccountFrm accountFrm = SingletonProvider.getInstanceAccountFrm();
        JDialogGenBill pac = new JDialogGenBill(accountFrm);
        String a=SingletonProvider.getInstanceAccountManager().generateReport().toString();
        pac.setReport(a);
        pac.setBounds(450, 20, 300, 330);
        pac.show();		
	}
}

