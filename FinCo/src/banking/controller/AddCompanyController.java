package banking.controller;

import java.awt.event.ActionEvent;

import banking.dialog.CompanyDialog;
import banking.type.MyAccountType;
import framework.app.customer.Company;
import framework.app.type.CustomerType;
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

public class AddCompanyController extends AccountController {

	public AddCompanyController() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		AccountFrm accountFrm = SingletonProvider.getInstanceAccountFrm();
		CompanyDialog pac = new CompanyDialog(accountFrm);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
	}

	public void createAccount(MyAccountType accountType, String name, String ct, String st, String str, String zip,
			String acnr, String noe, String em) {
		IAccount account = ((AccountFactory) FincoFactory.getFactory(MyAccountType.MYAC)).getAccount(accountType);
		AAccount aAccount = (AAccount) account;
		aAccount.setAcctNumber(acnr);

		account = aAccount;
		ICustomer customer = ((CustomerFactory) FincoFactory.getFactory(Types.CUSTOMER)).getCustomer(CustomerType.COMPANY);
		Company c = (Company) customer;
		c.setName(name);
		c.setCity(ct);
		c.setState(st);
		c.setStreet(str);
		c.setZip(zip);
		try {
			c.setNoOfEmployee(Integer.parseInt(noe));
		} catch (NumberFormatException e) {
			System.err.println("Number formate in noofemplyee");
			c.setNoOfEmployee(1);
		}
		c.setEmail(em);
		customer = c;
		customer.addAccount(account);
		SingletonProvider.getInstanceAccountManager().addAccountToList(account);
	}

}
