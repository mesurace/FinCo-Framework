package com.asd.group1.framework.lib.transaction;

import java.util.Date;

/**
 *
 * @author Manish Karki
 */
public abstract class ATransaction implements ITransaction {
	private double amount;
	private Date date;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
