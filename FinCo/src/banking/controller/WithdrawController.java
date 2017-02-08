
package banking.controller;

import java.awt.event.ActionEvent;

import banking.dialog.WithdrawDialog;
import framework.gui.AccountFrm;
import framework.gui.JDialog_Dialogview;
import singleton.SingletonProvider;

public class WithdrawController extends framework.gui.controller.WithdrawController {

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
