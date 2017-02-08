package framework.lib.customer;

import java.util.ArrayList;
import java.util.List;

import framework.lib.account.IAccount;

/**
 * @author Suresh Adhikari
 *
 */
public abstract class ACustomer implements ICustomer {
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String email;
	private List<IAccount> accountList;

	public ACustomer() {
		accountList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<IAccount> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<IAccount> accountList) {
		this.accountList = accountList;
	}

	@Override
	public void addAccount(IAccount account) {
		this.accountList.add(account);
		account.setCustomer(this);
	}

	public double getBalance() {
		double balance = 0;
		for (IAccount account : this.getAccountList()) {
			balance += account.getCurrentBalance();
		}
		return balance;
	}

}
