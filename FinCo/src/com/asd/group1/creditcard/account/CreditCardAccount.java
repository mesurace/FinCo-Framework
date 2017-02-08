package com.asd.group1.creditcard.account;

import com.asd.group1.framework.lib.account.AAccount;

/**
 *
 * @author Manish Karki
 */
public class CreditCardAccount extends AAccount {

	String expiryDate;
	double lastMonthBalance;

	public CreditCardAccount() {
	}

	@Override
	public double getInterestAmount() {
		return 10;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getLastMonthBalance() {
		return lastMonthBalance;
	}

	public void setLastMonthBalance(double lastMonthBalance) {
		this.lastMonthBalance = lastMonthBalance;
	}

}
