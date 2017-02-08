package banking.dialog;

import java.awt.event.ActionEvent;

import framework.gui.AccountFrm;
import framework.gui.JDialog_Dialogview;
import framework.gui.controller.WithdrawController;

public class WithdrawDialog extends JDialog_Dialogview {

	public WithdrawDialog(AccountFrm parent, String aaccnr) {
		super(parent, aaccnr);
		setTitle("Withdraw Money");
	}

	@Override
	protected void JButtonOK_actionPerformed(ActionEvent event) {
		String name = JTextField_NAME.getText();
		String amount = JTextField_Deposit.getText();
		new WithdrawController().withdraw(this.getAccnr(), amount, name);
		dispose();
		setVisible(false);
	}
}
