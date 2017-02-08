
package banking.controller;

import java.awt.event.ActionEvent;
import java.util.Date;

import banking.dialog.PersonDialog;
import banking.type.MyAccountType;
import framework.app.customer.Person;
import framework.app.type.PartyType;
import framework.app.type.Types;
import framework.gui.AccountFrm;
import framework.gui.controller.AccountController;
import framework.lib.account.AAccount;
import framework.lib.account.IAccount;
import framework.lib.customer.ICustomer;
import framework.lib.factory.AccountFactory;
import framework.lib.factory.CustomerFactory;
import framework.lib.factory.FincoFactory;
import singleton.SingletonProvider;

public class AddPersonController extends AccountController {

	public AddPersonController() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		AccountFrm accountFrm = SingletonProvider.getInstanceAccountFrm();
		PersonDialog pac = new PersonDialog(accountFrm);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
	}

	public void createAccount(MyAccountType accountType, String name, String ct, String st, String str, String zip,
			String acnr, String bd, String em) {

		IAccount account = ((AccountFactory) FincoFactory.getFactory(MyAccountType.MYAC)).getAccount(accountType);
		ICustomer customer = ((CustomerFactory) FincoFactory.getFactory(Types.CUSTOMER))
				.getCustomer(PartyType.PERSONAL);
		AAccount aAccount = (AAccount) account;
		aAccount.setAcctNumber(acnr);

		account = aAccount;

		Person c = (Person) customer;
		c.setName(name);
		c.setCity(ct);
		c.setState(st);
		c.setStreet(str);
		c.setZip(zip);
		try {
			c.setDateOfBirth(new Date(bd));
		} catch (IllegalArgumentException e) {
			System.err.println("IllegalArgumentException in setDateOfBirth");
		}
		c.setEmail(em);
		customer = c;
		customer.addAccount(account);
		SingletonProvider.getInstanceAccountManager().addAccountToList(account);

	}
}
