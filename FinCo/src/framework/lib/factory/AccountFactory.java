package framework.lib.factory;

import framework.app.model.FincoAccount;
import framework.app.type.AccountType;
import framework.lib.account.IAccount;

/**
 *
 * @author Manish Karki
 */
@SuppressWarnings({ "rawtypes"})
public class AccountFactory extends AbstractFactory{

	public IAccount getAccount(Enum type){
		if (type == AccountType.DEFAULT_ACCOUNT) {
            return new FincoAccount();
        }
        return null;
	}
}

