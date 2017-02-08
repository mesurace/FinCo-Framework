
package banking.dialog;

import java.awt.event.ActionEvent;

import banking.controller.AddCompanyController;
import banking.type.MyAccountType;
import framework.gui.AccountFrm;
import framework.gui.JDialog_AddAccount;

public class CompanyDialog extends JDialog_AddAccount {

	public CompanyDialog(AccountFrm parent) {
		super(parent);
		setTitle("Add Company Account");

		JLabel6.setText("No of employees");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12, 204, 96, 24);

		repaint();
	}

	@Override
	protected void JButtonOK_actionPerformed(ActionEvent event) {
		String name, ct, st, str, zip, acnr, noe, em;
		name = JTextField_NAME.getText();
		ct = JTextField_CT.getText();
		st = JTextField_ST.getText();
		str = JTextField_STR.getText();
		zip = JTextField_ZIP.getText();
		acnr = JTextField_ACNR.getText();
		noe = JTextField_BD.getText();
		em = JTextField_EM.getText();
		if (JRadioButton_Chk.isSelected()) {
			MyAccountType accountType = MyAccountType.CHECKING;
			new AddCompanyController().createAccount(accountType, name, ct, st, str, zip, acnr, noe, em);
		} else if (JRadioButton_Sav.isSelected()) {
			MyAccountType accountType = MyAccountType.SAVING;
			new AddCompanyController().createAccount(accountType, name, ct, st, str, zip, acnr, noe, em);
		}
		dispose();
		setVisible(false);

	}

}
