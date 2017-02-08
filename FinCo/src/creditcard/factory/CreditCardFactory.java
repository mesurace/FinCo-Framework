package creditcard.factory;

import creditcard.account.Bronze;
import creditcard.account.Gold;
import creditcard.account.Silver;
import creditcard.type.CreditAccountType;
import framework.lib.account.IAccount;
import framework.lib.factory.AccountFactory;

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

