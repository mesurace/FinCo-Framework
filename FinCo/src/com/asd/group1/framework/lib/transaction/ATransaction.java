package com.asd.group1.framework.lib.transaction;

import java.util.Date;

import com.asd.group1.framework.lib.model.IAccount;

/**
 *
 * @author Manish Karki
 */
public abstract class ATransaction implements ITransaction {
	private double amount;
	private String name;
	private Date date;
	private IAccount account;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
    public IAccount getAccount() {
        return account;
    }

    @Override
    public void setAccount(IAccount account) {
        this.account = account;
    }

}
