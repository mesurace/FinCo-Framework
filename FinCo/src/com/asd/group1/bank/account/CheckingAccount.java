
package com.asd.group1.bank.account;

import com.asd.group1.framework.lib.account.AAccount;
import com.asd.group1.framework.lib.customer.ICustomer;

public class CheckingAccount extends AAccount {

    public CheckingAccount() {
        super.setType("Ch");
    }

    
    
    @Override
    public String getType() {
        return "Ch";
    }

    @Override
    public double getInterestAmount() {
        return 3;
    }

    @Override
    public void setCustomer(ICustomer iCustomer) {
        super.setCustomer(iCustomer);
    }

    @Override
    public ICustomer getCustomer() {
        return super.getCustomer();
    }
    
//    public double getBalance() {
//        return super.getBalance();
//    }
}
