package com.asd.group1.creditcard.controller;

import java.awt.event.ActionEvent;

import com.asd.group1.creditcard.account.CreditCardAccount;
import com.asd.group1.creditcard.dialog.CreditCardDialog;
import com.asd.group1.creditcard.type.CreditAccountType;
import com.asd.group1.framework.app.customer.Person;
import com.asd.group1.framework.app.type.PartyType;
import com.asd.group1.framework.app.type.Types;
import com.asd.group1.framework.gui.AccountFrm;
import com.asd.group1.framework.gui.controller.AccountController;
import com.asd.group1.framework.lib.account.IAccount;
import com.asd.group1.framework.lib.customer.ICustomer;
import com.asd.group1.framework.lib.factory.AccountFactory;
import com.asd.group1.framework.lib.factory.CustomerFactory;
import com.asd.group1.framework.lib.factory.FincoFactory;
import com.asd.group1.singleton.SingletonProvider;

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
