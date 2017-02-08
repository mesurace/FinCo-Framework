package banking.controller;

import java.awt.event.ActionEvent;

import banking.dialog.DepositDialog;
import framework.gui.AccountFrm;
import framework.gui.JDialog_Dialogview;
import singleton.SingletonProvider;

public class DepositController extends framework.gui.controller.DepositController {

	public DepositController() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		AccountFrm accountFrm = SingletonProvider.getInstanceAccountFrm();
		String accnr = accountFrm.getAccountNo();
		JDialog_Dialogview dep = new DepositDialog(accountFrm, accnr);
		dep.setBounds(430, 15, 275, 140);
		dep.show();
	}

}
