
package banking.dialog;

import java.awt.event.ActionEvent;

import banking.controller.AddPersonController;
import banking.type.MyAccountType;
import framework.gui.AccountFrm;
import framework.gui.JDialog_AddAccount;

public class PersonDialog extends JDialog_AddAccount {

	public PersonDialog(AccountFrm parent) {
		super(parent);
		setTitle("Add Person Account");

		JLabel6.setText("Birthdate");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12, 204, 96, 24);

	}

	@Override
	protected void JButtonOK_actionPerformed(ActionEvent event) {
		String name, ct, st, str, zip, acnr, bd, em;
		name = JTextField_NAME.getText();
		ct = JTextField_CT.getText();
		st = JTextField_ST.getText();
		str = JTextField_STR.getText();
		zip = JTextField_ZIP.getText();
		acnr = JTextField_ACNR.getText();
		bd = JTextField_BD.getText();
		em = JTextField_EM.getText();
		if (JRadioButton_Chk.isSelected()) {
			MyAccountType accountType = MyAccountType.CHECKING;
			new AddPersonController().createAccount(accountType, name, ct, st, str, zip, acnr, bd, em);
		} else if (JRadioButton_Sav.isSelected()) {
			MyAccountType accountType = MyAccountType.SAVING;
			new AddPersonController().createAccount(accountType, name, ct, st, str, zip, acnr, bd, em);
		}
		dispose();
		setVisible(false);
	}

}
