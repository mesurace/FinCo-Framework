package com.asd.group1.creditcard.factory;

import com.asd.group1.creditcard.account.Bronze;
import com.asd.group1.creditcard.account.Gold;
import com.asd.group1.creditcard.account.Silver;
import com.asd.group1.creditcard.type.CreditAccountType;
import com.asd.group1.framework.lib.account.IAccount;
import com.asd.group1.framework.lib.factory.AccountFactory;

/**
 *
 * @author Manish Karki
 */
public class CreditCardFactory extends AccountFactory {
	
	public CreditCardFactory() {
    }

    @SuppressWarnings("rawtypes")
	@Override
    public IAccount getAccount(Enum type) {
       if (type == CreditAccountType.GOLD) {
            return new Gold();
        } else if (type == CreditAccountType.SILVER) {
            return new Silver();
        } else if (type == CreditAccountType.BROZE) {
            return new Bronze();
        }
        return null;
    }
    

}

