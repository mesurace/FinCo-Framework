package creditcard.controller;

import java.awt.event.ActionEvent;

import creditcard.account.CreditCardAccount;
import creditcard.dialog.CreditCardDialog;
import creditcard.type.CreditAccountType;
import framework.app.customer.Person;
import framework.app.type.PartyType;
import framework.app.type.Types;
import framework.gui.AccountFrm;
import framework.gui.controller.AccountController;
import framework.lib.account.IAccount;
import framework.lib.customer.ICustomer;
import framework.lib.factory.AccountFactory;
import framework.lib.factory.CustomerFactory;
import framework.lib.factory.FincoFactory;
import singleton.SingletonProvider;

/**
 *
 * @author Manish Karki
 */
@SuppressWarnings({ "rawtypes", "deprecation" })
public class AddCreditCardController extends AccountController {

	@Override
	public void actionPerformed(ActionEvent ae) {
		AccountFrm accountFrm = SingletonProvider.getInstanceAccountFrm();
		CreditCardDialog pac = new CreditCardDialog(accountFrm);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
	}

	public void createAccount(Enum accountType, String name, String ct, String st, String str, String zip, String acnr,
			String expdate, String em) {
		IAccount account = ((AccountFactory) FincoFactory.getFactory(CreditAccountType.MYAC)).getAccount(accountType);
		CreditCardAccount aAccount = (CreditCardAccount) account;
		aAccount.setAcctNumber(acnr);
		try {
			aAccount.setExpiryDate(expdate);
		} catch (IllegalArgumentException e) {
			System.err.println("IllegalArgumentException in setDateOfBirth");
			aAccount.setExpiryDate("02/08/2017");
		}
		account = aAccount;

		ICustomer customer = ((CustomerFactory) FincoFactory.getFactory(Types.CUSTOMER))
				.getCustomer(PartyType.PERSONAL);
		Person c = (Person) customer;
		c.setName(name);
		c.setCity(ct);
		c.setState(st);
		c.setStreet(str);
		c.setZip(zip);
		c.setEmail(em);
		customer = c;
		customer.addAccount(account);
		SingletonProvider.getInstanceAccountManager().addAccountToList(account);

	}

}
