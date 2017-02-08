
package com.asd.group1.bank.dialog;

import java.awt.event.ActionEvent;

import com.asd.group1.framework.gui.AccountFrm;
import com.asd.group1.framework.gui.JDialog_Dialogview;
import com.asd.group1.framework.gui.controller.DepositController;

public class DepositDialog extends JDialog_Dialogview {

	public DepositDialog(AccountFrm parent, String aaccnr) {
		super(parent, aaccnr);
		setTitle("Deposit Money");
	}

	@Override
	protected void JButtonOK_actionPerformed(ActionEvent event) {
		String name = JTextField_NAME.getText();
		String amount = JTextField_Deposit.getText();
		new DepositController().deposit(this.getAccnr(), amount, name);
		dispose();
		setVisible(false);
	}

}
