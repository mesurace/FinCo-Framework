
package com.asd.group1.bank.factory;


import com.asd.group1.bank.account.CheckingAccount;
import com.asd.group1.bank.account.SavingAccount;
import com.asd.group1.bank.type.MyAccountType;
import com.asd.group1.framework.lib.factory.AccountFactory;
import com.asd.group1.framework.lib.account.IAccount;


public class MyAccountFactory extends AccountFactory {

    public MyAccountFactory() {
    }

    @Override
    public IAccount getAccount(Enum type) {
        if (type == MyAccountType.CHECKING) {
            return new CheckingAccount();
        } else if (type == MyAccountType.SAVING) {
            return new SavingAccount();
        }
        return null;
    }

}
