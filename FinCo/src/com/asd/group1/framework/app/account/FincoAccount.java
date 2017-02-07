package com.asd.group1.framework.app.account;

import com.asd.group1.framework.lib.account.AAccount;
import com.asd.group1.framework.lib.customer.ICustomer;

/**
 *
 * @author Manish Karki
 */
public class FincoAccount extends AAccount {

    public static final String TYPE = "D";

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public double getInterestAmount() {
        return 0;
    }

    @Override
    public void setCustomer(ICustomer iCustomer) {
        super.setCustomer(iCustomer);
    }

    @Override
    public ICustomer getCustomer() {
        return super.getCustomer();
    }

}

